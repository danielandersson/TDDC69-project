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
 * The Class Ghost.
 */
public class Ghost implements Mode {
	
	/** The TIME. */
	private static final int TIME = 5000;
	
	/** The SPEED. */
	private static final int SPEED = 5;
	
	/** The texture. */
	private static BufferedImage texture = null;

	/**
	 * Instantiates a new ghost.
	 */
	public Ghost() {
		if (texture == null)
			texture = ResourceHandler.getImage("ghostcar.png");
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#collisionAble()
	 */
	@Override
	public boolean collisionAble() {
		return false;
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
		if (p.isAlive())
			p.setyCoord(p.getyCoord() - SPEED);
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#moveLeft(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void moveLeft(Player p) {
		if (p.isAlive())
			p.setxCoord(p.getxCoord() - SPEED);
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#moveRight(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void moveRight(Player p) {
		if (p.isAlive())
			p.setxCoord(p.getxCoord() + SPEED);
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.player.Mode#moveUp(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void moveUp(Player p) {
		if (p.isAlive())
			p.setyCoord(p.getyCoord() + SPEED);
	}
}
