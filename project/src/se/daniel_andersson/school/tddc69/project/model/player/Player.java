/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model.player;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import se.daniel_andersson.school.tddc69.project.model.player.Modes.Normal;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player {

	/** The X coord. */
	private int XCoord;
	
	/** The Y coord. */
	private int YCoord;
	
	/** The current mode. */
	private Mode currentMode = new Normal();
	
	/** The level advance. */
	private boolean levelAdvance = false;
	
	/** The life. */
	private int life = 5;

	/**
	 * Instantiates a new player.
	 *
	 * @param XCoord the x coord
	 * @param YCoord the y coord
	 */
	public Player(int XCoord, int YCoord) {
		this.XCoord = XCoord;
		this.YCoord = YCoord;
	}

	/**
	 * Collision able.
	 *
	 * @return true, if successful
	 */
	public boolean collisionAble() {
		return currentMode.collisionAble();
	}

	/**
	 * Gets the current mode.
	 *
	 * @return the current mode
	 */
	public Mode getCurrentMode() {
		return currentMode;
	}

	/**
	 * Gets the life.
	 *
	 * @return the life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return currentMode.getSpeed();
	}

	/**
	 * Gets the texture.
	 *
	 * @return the texture
	 */
	public BufferedImage getTexture() {
		return currentMode.getTexture();
	}

	/**
	 * Gets the x coord.
	 *
	 * @return the x coord
	 */
	public int getXCoord() {
		return XCoord;
	}

	/**
	 * Gets the y coord.
	 *
	 * @return the y coord
	 */
	public int getYCoord() {
		return YCoord;
	}

	/**
	 * Checks if is alive.
	 *
	 * @return true, if is alive
	 */
	public boolean isAlive() {
		return life > 0;
	}

	/**
	 * Checks if is level advance.
	 *
	 * @return true, if is level advance
	 */
	public boolean isLevelAdvance() {
		return levelAdvance;
	}

	/**
	 * Move down.
	 */
	public void moveDown() {
		currentMode.moveDown(this);
	}

	/**
	 * Move left.
	 */
	public void moveLeft() {
		currentMode.moveLeft(this);
	}

	/**
	 * Move right.
	 */
	public void moveRight() {
		currentMode.moveRight(this);
	}

	/**
	 * Move up.
	 */
	public void moveUp() {
		currentMode.moveUp(this);
	}

	/**
	 * Sets the current mode.
	 *
	 * @param mode the new current mode
	 */
	public void setCurrentMode(Mode mode) {
		Date timeToRun = new Date(System.currentTimeMillis() + mode.getTime());
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				currentMode = new Normal();
			}
		}, timeToRun);
		currentMode = mode;
	}

	/**
	 * Sets the level advance.
	 *
	 * @param levelAdvance the new level advance
	 */
	public void setLevelAdvance(boolean levelAdvance) {
		this.levelAdvance = levelAdvance;
	}

	/**
	 * Sets the x coord.
	 *
	 * @param XCoord the new x coord
	 */
	public void setXCoord(int XCoord) {
		this.XCoord = XCoord;
	}

	/**
	 * Sets the y coord.
	 *
	 * @param YCoord the new y coord
	 */
	public void setYCoord(int YCoord) {
		this.YCoord = YCoord;
	}

	/**
	 * Take damage.
	 */
	public void takeDamage() {
		life--;
	}
}
