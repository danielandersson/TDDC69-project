package se.daniel_andersson.school.tddc69.project.model;

import java.awt.image.BufferedImage;

import se.daniel_andersson.school.tddc69.project.model.player.Player;

/**
 * The interface for all game objects on the map.
 */
public abstract interface GameObject {

	/**
	 * Collision with the player, each subclass then has individual impacts.
	 *
	 * @param object the player
	 */
	public abstract void collision(Player object);

    /**
	 * Gets the texture.
	 *
	 * @return the texture
	 */
	public abstract BufferedImage getTexture();

}
