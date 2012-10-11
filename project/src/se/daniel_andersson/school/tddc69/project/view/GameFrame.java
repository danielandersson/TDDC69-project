/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.view;

import se.daniel_andersson.school.tddc69.project.controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class GameFrame.
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	/** The graphical viewer. */
	private final JComponent graphicalViewer;

	/**
	 * Instantiates a new game frame.
	 *
	 * @param mainGame the main game
	 */
	public GameFrame(final Game mainGame) {
		super("Projectname");
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		super.setLayout(new BorderLayout());
		graphicalViewer = new GraphicalViewer(mainGame);
		super.add(graphicalViewer, BorderLayout.CENTER);

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

		graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("UP"),
				"moveUp");
		graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),
				"moveLeft");
		graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),
				"moveRight");
		graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),
				"moveDown");
		graphicalViewer.getActionMap().put("moveUp", moveUp);
		graphicalViewer.getActionMap().put("moveLeft", moveLeft);
		graphicalViewer.getActionMap().put("moveRight", moveRight);
		graphicalViewer.getActionMap().put("moveDown", moveDown);
		super.pack();
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#repaint()
	 */
	@Override
	public void repaint() {
		graphicalViewer.repaint();
	}
}
