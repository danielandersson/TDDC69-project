package se.daniel_andersson.school.tddc69.project.controller.states;

import se.daniel_andersson.school.tddc69.project.controller.Game;
import se.daniel_andersson.school.tddc69.project.model.State;
import se.daniel_andersson.school.tddc69.project.view.GraphicalGameViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

/**
 * The GameState class which is handling all the output of the game.
 */
@SuppressWarnings("serial")
public class GameState extends State {
    private Game mainGame;
    private GraphicalGameViewer graphicalGameViewer;
    private long prevTimer;

	/**
	 * Instantiates a new game state.
	 */
	public GameState() {
		super("GameState");
		mainGame = new Game();
		graphicalGameViewer = new GraphicalGameViewer(mainGame);
		screen = new BufferedImage(
				graphicalGameViewer.getPreferredSize().width,
				graphicalGameViewer.getPreferredSize().height,
				BufferedImage.TYPE_INT_RGB);
		updateInputMap();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(graphicalGameViewer.getPreferredSize());
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(Integer.parseInt(
				mainGame.getLevel().getBgColor(), 16)));
		g2.fill(this.getBounds());
		graphicalGameViewer.paintComponent(g2);
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.State#update()
	 */
	@Override
	public void update() {
		if (mainGame.isGameCompleted()) {
			getListener().stateChanged("GameCompletedState");
			System.out.println("Du klarade spelet med " + mainGame.getTotalPoint() + " poäng!");
            mainGame = new Game();
            graphicalGameViewer = new GraphicalGameViewer(mainGame);
		} else if (mainGame.gameOver()) {
			getListener().stateChanged("GameOverState");
			System.out.println("Du dog med " + mainGame.getTotalPoint() + " poäng.");
            mainGame = new Game();
            graphicalGameViewer = new GraphicalGameViewer(mainGame);
		} else {
			if (prevTimer + 90 < System.currentTimeMillis()) {
				super.update();
				mainGame.gameTick();
				prevTimer = System.currentTimeMillis();
			}
		}
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.State#updateInputMap()
	 */
	@Override
	public void updateInputMap() {
		System.out.println("Uppdaterar Inputs");

		final Action moveUp = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainGame.getPlayer().getyCoord()
						+ mainGame.getPlayer().getSpeed() < mainGame.getLevel()
						.getScreenHeight()
						* mainGame.getLevel().getTileHeight())
					mainGame.getPlayer().moveUp();
			}
		};
		final Action moveLeft = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainGame.getPlayer().getxCoord() > 0)
					mainGame.getPlayer().moveLeft();
			}
		};
		final Action moveRight = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainGame.getPlayer().getxCoord() < mainGame.getLevel()
						.getLevelWidth()
						* mainGame.getLevel().getTileWidth()
						- mainGame.getLevel().getTileWidth())
					mainGame.getPlayer().moveRight();
			}
		};
		final Action moveDown = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainGame.getPlayer().getyCoord() > mainGame.getLevel()
						.getTileHeight())
					mainGame.getPlayer().moveDown();
			}
		};
        final Action returnToMenu = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getListener().stateChanged("MenuState");
            }
        };

		super.getInputMap().put(KeyStroke.getKeyStroke("UP"), "moveUp");
		super.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
		super.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
		super.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        super.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "returnToMenu");
		super.getActionMap().put("moveUp", moveUp);
		super.getActionMap().put("moveLeft", moveLeft);
		super.getActionMap().put("moveRight", moveRight);
		super.getActionMap().put("moveDown", moveDown);
        super.getActionMap().put("returnToMenu", returnToMenu);
	}
}
