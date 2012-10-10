/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.controller;

import se.daniel_andersson.school.tddc69.project.model.Level;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 */
public class Game {

	/** The player. */
	private final Player player;
	
	/** The current level. */
	private Level currentLevel;
	
	/** The game completed. */
	private boolean gameCompleted;

	/** The levels completed. */
	private int levelsCompleted;

	/**
	 * Instantiates a new game.
	 */
	public Game() {
		currentLevel = new Level(1);
		player = new Player(currentLevel.getTileWidth()
				* currentLevel.getStartX(), currentLevel.getTileHeight()
				* currentLevel.getStartY());
	}

	/**
	 * Game over.
	 *
	 * @return true, if successful
	 */
	public boolean gameOver() {
		return !player.isAlive();
	}

	/**
	 * Game tick.
	 */
	public void gameTick() {
		if (player.isLevelAdvance()) {
			levelsCompleted++;
			if (currentLevel.getNextLevel() == 0)
				gameCompleted = true;
			else {
				currentLevel = new Level(currentLevel.getNextLevel());
				player.setXCoord(currentLevel.getTileWidth()
						* currentLevel.getStartX());
				player.setYCoord(currentLevel.getTileHeight()
						* currentLevel.getStartY());
				player.setLevelAdvance(false);
			}
		} else {
			if (player.collisionAble()) {
				int prevLife = player.getLife();
				currentLevel.collision(player);
				if (player.getLife() != prevLife) {
					currentLevel = new Level(currentLevel.getID());
					player.setXCoord(currentLevel.getTileWidth()
							* currentLevel.getStartX());
					player.setYCoord(currentLevel.getTileHeight()
							* currentLevel.getStartY());
				}
			}
			if (!levelComplete())
				currentLevel.updateLevelIndex();
		}
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Level getLevel() {
		return currentLevel;
	}

	/**
	 * Gets the levels completed.
	 *
	 * @return the levels completed
	 */
	public int getLevelsCompleted() {
		return levelsCompleted;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Checks if is game completed.
	 *
	 * @return true, if is game completed
	 */
	public boolean isGameCompleted() {
		return gameCompleted;
	}

	/**
	 * Level complete.
	 *
	 * @return true, if successful
	 */
	public boolean levelComplete() {
		return currentLevel.reachedEnd();
	}
}
