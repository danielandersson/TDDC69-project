/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model;

import se.daniel_andersson.school.tddc69.project.TestStateGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceHandler.
 */
public class ResourceHandler {

	/**
	 * Gets the image.
	 *
	 * @param image the image
	 * @return the image
	 */
	public static BufferedImage getImage(String image) {
		try {
			File file = new File(TestStateGame.class.getResource(
					"assets/img/" + image).getFile());
			System.out.println("Read image: " + file.getAbsolutePath());
			return ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("Image " + image + " do not exist.");
			System.exit(10);
			return null;
		}
	}

	/**
	 * Gets the level file.
	 *
	 * @param f the f
	 * @return the level file
	 */
	public static File getLevelFile(String f) {
        File file;
        try {
            file = new File(TestStateGame.class.getResource(
                    "assets/level/" + f).getFile());
            System.out.println("Read file: " + file.getAbsolutePath());
            return file;
        } catch (Exception e) {
            System.out.println("File " + f + " do not exist.");
            System.exit(10);
            return null;
        }
	}

	/**
	 * Instantiates a new resource handler.
	 */
	private ResourceHandler() {
	}
}
