/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.controller.states;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import se.daniel_andersson.school.tddc69.project.controller.Game;
import se.daniel_andersson.school.tddc69.project.model.State;
import se.daniel_andersson.school.tddc69.project.view.GraphicalStateViewer;

// TODO: Auto-generated Javadoc
/**
 * The Class GameState.
 */
@SuppressWarnings("serial")
public class GameState extends State {

	/** The main game. */
	Game mainGame;
	
	/** The graphical state viewer. */
	GraphicalStateViewer graphicalStateViewer;
	
	/** The prev timer. */
	long prevTimer;

	/**
	 * Instantiates a new game state.
	 */
	public GameState() {
		super("GameState");
		mainGame = new Game();
		graphicalStateViewer = new GraphicalStateViewer(mainGame);
		screen = new BufferedImage(
				graphicalStateViewer.getPreferredSize().width,
				graphicalStateViewer.getPreferredSize().height,
				BufferedImage.TYPE_INT_RGB);
		updateInputMap();
	}

	/*
	 * @Override public void render() { Graphics2D g2 = getGraphics2D();
	 * g2.setColor(new Color(Integer.parseInt(mainGame.getLevel().getBgColor(),
	 * 16))); g2.setColor(Color.BLACK); g2.fill(this.getBounds());
	 * graphicalStateViewer.paintComponent(g2); super.render(); }
	 */

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(graphicalStateViewer.getPreferredSize());
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
		graphicalStateViewer.paintComponent(g2);
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.State#update()
	 */
	@Override
	public void update() {
		if (mainGame.isGameCompleted()) {
			mainGame = new Game();
			graphicalStateViewer = new GraphicalStateViewer(mainGame);
			getListener().stateChanged("MenuState");
			System.out.println("Du klarade spelet!!");
		} else if (mainGame.gameOver()) {
			mainGame = new Game();
			graphicalStateViewer = new GraphicalStateViewer(mainGame);
			getListener().stateChanged("MenuState");
			System.out.println("Du doooog!!!!");
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
				if (mainGame.getPlayer().getYCoord()
						+ mainGame.getPlayer().getSpeed() < mainGame.getLevel()
						.getScreenHeight()
						* mainGame.getLevel().getTileHeight())
					mainGame.getPlayer().moveUp();
			}
		};
		final Action moveLeft = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainGame.getPlayer().getXCoord() > 0)
					mainGame.getPlayer().moveLeft();
			}
		};
		final Action moveRight = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainGame.getPlayer().getXCoord() < mainGame.getLevel()
						.getLevelWidth()
						* mainGame.getLevel().getTileWidth()
						- mainGame.getLevel().getTileWidth())
					mainGame.getPlayer().moveRight();
			}
		};
		final Action moveDown = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainGame.getPlayer().getYCoord() > mainGame.getLevel()
						.getTileHeight())
					mainGame.getPlayer().moveDown();
			}
		};

		super.getInputMap().put(KeyStroke.getKeyStroke("UP"), "moveUp");
		super.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
		super.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
		super.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
		super.getActionMap().put("moveUp", moveUp);
		super.getActionMap().put("moveLeft", moveLeft);
		super.getActionMap().put("moveRight", moveRight);
		super.getActionMap().put("moveDown", moveDown);
	}
}
