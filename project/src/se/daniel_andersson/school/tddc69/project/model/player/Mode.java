/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model.player;

import java.awt.image.BufferedImage;

// TODO: Auto-generated Javadoc
/**
 * The Interface Mode.
 */
public interface Mode {
	
	/**
	 * Collision able.
	 *
	 * @return true, if successful
	 */
	public boolean collisionAble();

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed();

	/**
	 * Gets the texture.
	 *
	 * @return the texture
	 */
	public BufferedImage getTexture();

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public int getTime();

	/**
	 * Move down.
	 *
	 * @param p the p
	 */
	public void moveDown(Player p);

	/**
	 * Move left.
	 *
	 * @param p the p
	 */
	public void moveLeft(Player p);

	/**
	 * Move right.
	 *
	 * @param p the p
	 */
	public void moveRight(Player p);

	/**
	 * Move up.
	 *
	 * @param p the p
	 */
	public void moveUp(Player p);
}
