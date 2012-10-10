/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model.objects;

import java.awt.image.BufferedImage;

import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.Solid;

// TODO: Auto-generated Javadoc
/**
 * The Class Stone.
 */
public class Stone extends Solid {
	
	/** The texture. */
	private static BufferedImage texture = null;

	/**
	 * Instantiates a new stone.
	 */
	public Stone() {
		if (texture == null)
			texture = ResourceHandler.getImage("stone.png");
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
