package se.daniel_andersson.school.tddc69.project.model.objects;

import se.daniel_andersson.school.tddc69.project.model.PowerUp;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Fast;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.image.BufferedImage;

/**
 * The class for the Fast Buff object
 */
public class FastBuff extends PowerUp {
	
	/** The texture. */
	private static BufferedImage texture = null;

	/**
	 * Instantiates a new fast buff.
	 */
	public FastBuff() {
		if (texture == null)
			texture = ResourceHandler.getImage("speed.png");
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.PowerUp#collision(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void collision(Player object) {
		object.setCurrentMode(new Fast());
	}

    /* (non-Javadoc)
      * @see se.daniel_andersson.school.tddc69.project.model.GameObject#getTexture()
      */
	@Override
	public BufferedImage getTexture() {
		return texture;
	}

}
