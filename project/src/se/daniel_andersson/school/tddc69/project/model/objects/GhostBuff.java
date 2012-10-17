package se.daniel_andersson.school.tddc69.project.model.objects;

import se.daniel_andersson.school.tddc69.project.model.PowerUp;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Ghost;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.image.BufferedImage;

/**
 * The class for the Ghost Buff object
 */
public class GhostBuff extends PowerUp {
	
	/** The texture. */
	private static BufferedImage texture = null;

	/**
	 * Instantiates a new ghost buff.
	 */
	public GhostBuff() {
		if (texture == null)
			texture = ResourceHandler.getImage("ghost.png");
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.PowerUp#collision(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void collision(Player object) {
		object.setCurrentMode(new Ghost());
	}

    /* (non-Javadoc)
      * @see se.daniel_andersson.school.tddc69.project.model.GameObject#getTexture()
      */
	@Override
	public BufferedImage getTexture() {
		return texture;
	}
}
