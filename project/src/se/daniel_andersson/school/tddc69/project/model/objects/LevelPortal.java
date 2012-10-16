package se.daniel_andersson.school.tddc69.project.model.objects;

import se.daniel_andersson.school.tddc69.project.model.GameObject;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.image.BufferedImage;

/**
 * The class for the Level Portal object
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
	public void collision(Player object) {
		object.setLevelAdvance(true);
	}

    /* (non-Javadoc)
      * @see se.daniel_andersson.school.tddc69.project.model.GameObject#getTexture()
      */
	@Override
	public BufferedImage getTexture() {
		return texture;
	}

}
