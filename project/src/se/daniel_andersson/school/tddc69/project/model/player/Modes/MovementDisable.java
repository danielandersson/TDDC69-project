/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model.player.Modes;

import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Mode;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.image.BufferedImage;

// TODO: Auto-generated Javadoc
/**
 * The Class MovementDisable.
 */
public class MovementDisable implements Mode {

	/** The texture. */
	private static BufferedImage texture = null;

	/** The TIME. */
	private static final int TIME = 5000;

	/** The SPEED. */
	private static final int SPEED = 0;
	
	/**
	 * Instantiates a new movement disable.
	 */
	public MovementDisable() {
		if (texture == null)
			texture = ResourceHandler.getImage("car.png");
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#collisionAble()
	 */
	@Override
	public boolean collisionAble() {
		return true;
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#getSpeed()
	 */
	@Override
	public int getSpeed() {
		return SPEED;
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#getTexture()
	 */
	@Override
	public BufferedImage getTexture() {
		return texture;
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#getTime()
	 */
	@Override
	public int getTime() {
		return TIME;
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#moveDown(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void moveDown(Player p) {
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#moveLeft(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void moveLeft(Player p) {
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#moveRight(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void moveRight(Player p) {
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#moveUp(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void moveUp(Player p) {
	}
}
