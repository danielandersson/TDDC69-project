/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model.objects;

import java.awt.image.BufferedImage;

import se.daniel_andersson.school.tddc69.project.model.GameObject;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class LevelPortal.
 */
public class LevelPortal implements GameObject {
	
	/** The texture. */
	private static BufferedImage texture = null;

	/**
	 * Instantiates a new level portal.
	 */
	public LevelPortal() {
		if (texture == null)
			texture = ResourceHandler.getImage("portal.png");
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.GameObject#collision(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void collision(Player p) {
		p.setLevelAdvance(true);
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.GameObject#destroy()
	 */
	@Override
	public void destroy() {
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.GameObject#getTexture()
	 */
	@Override
	public BufferedImage getTexture() {
		return texture;
	}

}
