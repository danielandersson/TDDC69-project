/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model.objects;

import java.awt.image.BufferedImage;

import se.daniel_andersson.school.tddc69.project.model.Liquid;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Player;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.MovementDisable;

// TODO: Auto-generated Javadoc
/**
 * The Class Oil.
 */
public class Oil extends Liquid {

	/** The texture. */
	private static BufferedImage texture = null;

	/**
	 * Instantiates a new oil.
	 */
	public Oil() {
		if (texture == null)
			texture = ResourceHandler.getImage("oil.png");
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.Liquid#collision(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void collision(Player p) {
		p.setCurrentMode(new MovementDisable());
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
