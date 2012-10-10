/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model.objects;

import java.awt.image.BufferedImage;

import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.Solid;

// TODO: Auto-generated Javadoc
/**
 * The Class Tree.
 */
public class Tree extends Solid {
	
	/** The texture. */
	private static BufferedImage texture = null;

	/**
	 * Instantiates a new tree.
	 */
	public Tree() {
		if (texture == null)
			texture = ResourceHandler.getImage("treed.png");
	}

    /* (non-Javadoc)
      * @see se.daniel_andersson.school.tddc69.project.model.GameObject#getTexture()
      */
	@Override
	public BufferedImage getTexture() {
		return texture;
	}
}
