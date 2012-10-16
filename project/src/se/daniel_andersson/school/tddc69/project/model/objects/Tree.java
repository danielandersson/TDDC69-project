package se.daniel_andersson.school.tddc69.project.model.objects;

import java.awt.image.BufferedImage;

import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.Solid;

/**
 * The class for the Tree object
 */
public class Tree extends Solid {
	
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
