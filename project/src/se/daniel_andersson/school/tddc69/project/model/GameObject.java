/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model;

import java.awt.image.BufferedImage;

import se.daniel_andersson.school.tddc69.project.model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Interface GameObject.
 */
public abstract interface GameObject {

	/**
	 * Collision.
	 *
	 * @param object the object
	 */
	public abstract void collision(Player object);

	/**
	 * Destroy.
	 */
	public abstract void destroy();

	/**
	 * Gets the texture.
	 *
	 * @return the texture
	 */
	public abstract BufferedImage getTexture();

}
