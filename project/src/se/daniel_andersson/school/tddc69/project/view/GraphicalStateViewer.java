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
 * The Class GraphicalStateViewer.
 */
@SuppressWarnings("serial")
public class GraphicalStateViewer extends JComponent {

	/** The width. */
	private static int componentWidth;
	
	/** The height. */
	private static int componentHeight;
	
	/** The main game. */
	private final Game mainGame;
	
	/** The Constant HEART_TEXTURE. */
	private static final BufferedImage HEART_TEXTURE = ResourceHandler
			.getImage("heart.png");

	/**
	 * Instantiates a new graphical state viewer.
	 *
	 * @param game the game
	 */
	public GraphicalStateViewer(Game game) {
		this.mainGame = game;
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
	 * Paint debug.
	 *
	 * @param g2 the g2
	 */
	@SuppressWarnings("unused")
	private void paintDebug(final Graphics2D g2) {
		int xMath = mainGame.getPlayer().getxCoord();
		int yMath = mainGame.getPlayer().getyCoord()
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
	 * Paint info.
	 *
	 * @param g2 the g2
	 */
	private void paintInfo(final Graphics2D g2) {
		g2.setColor(Color.RED);
		for (int i = mainGame.getPlayer().getLife(); i > 0; i--) {
			g2.drawImage(HEART_TEXTURE, 10 + (i * 25), mainGame.getLevel()
					.getScreenHeight()
					* (mainGame.getLevel().getTileHeight() - 2), null);
		}
	}

	/**
	 * Paint map.
	 *
	 * @param g2 the g2
	 */
	private void paintMap(final Graphics2D g2) {
		int k = 0;
		if (mainGame.getLevel().getTopIndex() > 0)
			k = 1;
		for (int i = mainGame.getLevel().getTopIndex() - k; i <= mainGame
				.getLevel().getBottomIndex(); i++) {
			for (int j = 0; j < mainGame.getLevel().getLevelWidth(); j++) {
				int xMath = mainGame.getLevel().getTileWidth() * j;
				int yMath = mainGame.getLevel().getTileHeight()
						* (i - mainGame.getLevel().getTopIndex())
						+ mainGame.getLevel().getInnerTile();
				if (mainGame.getLevel().getMap()[i][j] != null) {
					if (mainGame.getLevel().getMap()[i][j].getTexture() != null)
						g2.drawImage(mainGame.getLevel().getMap()[i][j]
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
	 * @param g2 the g2
	 */
	private void paintPlayer(final Graphics2D g2) {
		g2.setColor(Color.PINK);
		int XMath = mainGame.getPlayer().getxCoord();
		int YMath = componentHeight - (mainGame.getPlayer().getyCoord() + 1);
		g2.drawImage(mainGame.getPlayer().getTexture(), XMath, YMath, mainGame
				.getLevel().getTileWidth(),
				mainGame.getLevel().getTileHeight(), null);
	}
}
