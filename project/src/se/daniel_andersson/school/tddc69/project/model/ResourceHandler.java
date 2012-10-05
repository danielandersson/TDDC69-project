package se.daniel_andersson.school.tddc69.project.model;


import se.daniel_andersson.school.tddc69.project.TestGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceHandler {

    private ResourceHandler() {
    }

    public static BufferedImage getImage(String image) {
        try {
            File file = new File(TestGame.class.getResource("img/"+image).getFile());
            System.out.println("Read file: " + file.getAbsolutePath());
            return ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("File " + image+ " do not exist.");
            System.exit(0);
            return null;
        }
    }
}
