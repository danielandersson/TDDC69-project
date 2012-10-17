/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.view;

import se.daniel_andersson.school.tddc69.project.controller.Game;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// TODO: Auto-generated Javadoc
/**
 * The Class GraphicalGameViewer.
 */
@SuppressWarnings("serial")
public class GraphicalGameViewer extends JComponent {

	private static int componentWidth;
	private static int componentHeight;
	private static final BufferedImage HEART_TEXTURE = ResourceHandler
			.getImage("heart.png");
    private final Game mainGame;

	/**
	 * Instantiates a new graphical game viewer.
	 *
	 * @param game the mainGame
	 */
	public GraphicalGameViewer(Game game) {
		this.mainGame = game;
        // Calculates the Height & Width for the window.
		componentHeight = mainGame.getLevel().getScreenHeight()
				* mainGame.getLevel().getTileHeight();
		componentWidth = mainGame.getLevel().getLevelWidth()
				* mainGame.getLevel().getTileWidth();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(componentWidth, componentHeight);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(final Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		paintMap(g2);
		paintPlayer(g2);
		paintInfo(g2);
		// paintDebug(g2);
	}

	/**
	 * Paint debug information.
	 *
	 * @param g2 the Graphical2D
	 */
	@SuppressWarnings("unused")
	private void paintDebug(final Graphics2D g2) {
		int xMath = mainGame.getPlayer().getxCoord(); // Calculate players X coordinate
		int yMath = mainGame.getPlayer().getyCoord() // Calculate players Y coordinate
				- mainGame.getLevel().getTopIndex();
		g2.setColor(Color.BLUE);
		g2.drawString("Player X: " + mainGame.getPlayer().getxCoord()
				+ " Relative: " + xMath, 5, 15);
		g2.drawString("Player Y: " + mainGame.getPlayer().getyCoord()
				+ " Relative: " + yMath, 5, 25);
		g2.drawString("Player Mode: "
				+ mainGame.getPlayer().getCurrentMode().getClass()
						.getSimpleName(), 5, 35);

		g2.drawString("MapSize: H:" + mainGame.getLevel().getLevelHeight()
				+ " W:" + mainGame.getLevel().getLevelWidth(), 5, 50);
		g2.drawString("Map: " + mainGame.getLevel().getTopIndex() + " to "
				+ mainGame.getLevel().getBottomIndex(), 5, 60);

		g2.drawString("LevelComplete: " + mainGame.levelComplete(), 5, 75);
		g2.drawString("GameOver?: " + mainGame.gameOver(), 5, 85);
		g2.drawString("LevelsCompleted: " + mainGame.getLevelsCompleted(), 5,
				95);
	}

	/**
	 * Paint game info. Such as health and points.
	 *
	 * @param g2 the Graphical2D
	 */
	private void paintInfo(final Graphics2D g2) {
		g2.setColor(Color.RED);
		for (int i = mainGame.getPlayer().getLife(); i > 0; i--) { // Draw health with space between.
			g2.drawImage(HEART_TEXTURE, 10 + (i * 25), mainGame.getLevel()
					.getScreenHeight()
					* (mainGame.getLevel().getTileHeight() - 2), null);
		}
        g2.setColor(Color.RED);
        g2.drawString("Total Points: "+mainGame.getTotalPoint(), 25, 15);
        g2.drawString("Current Points: "+mainGame.getTemporaryPoint(), 25, 30);
	}

	/**
	 * Paint map.
	 *
	 * @param g2 the Graphical2D
	 */
	private void paintMap(final Graphics2D g2) {
		// For the scrolling we need to draw an additional row on the top of the window.
        int k = 0;
		if (mainGame.getLevel().getTopIndex() > 0)
            k = 1;

		for (int i = mainGame.getLevel().getTopIndex() - k; i <= mainGame
				.getLevel().getBottomIndex(); i++) {
            int yMath = mainGame.getLevel().getTileHeight() // Calculate Y coordinate for the map.
                    * (i - mainGame.getLevel().getTopIndex())
                    + mainGame.getLevel().getInnerTile();
			for (int j = 0; j < mainGame.getLevel().getLevelWidth(); j++) {
				int xMath = mainGame.getLevel().getTileWidth() * j; // Calculate X coordinate for the map.
				if (mainGame.getLevel().getMap()[i][j] != null) {
					if (mainGame.getLevel().getMap()[i][j].getTexture() != null)
						g2.drawImage(mainGame.getLevel().getMap()[i][j] // Draw the texture for the specific gameObject
								.getTexture(), xMath, yMath, mainGame
								.getLevel().getTileWidth(), mainGame.getLevel()
								.getTileHeight(), null);
				}
			}
		}
	}

	/**
	 * Paint player.
	 *
	 * @param g2 the Graphical2D
	 */
	private void paintPlayer(final Graphics2D g2) {
		g2.setColor(Color.PINK);
		int xMath = mainGame.getPlayer().getxCoord(); // Calculate the X coordinate for the player.
		int yMath = componentHeight - (mainGame.getPlayer().getyCoord() + 1); // Calculate the Y coordinate for the player.
		g2.drawImage(mainGame.getPlayer().getTexture(), xMath, yMath, mainGame
				.getLevel().getTileWidth(),
				mainGame.getLevel().getTileHeight(), null);
	}
}
