package se.daniel_andersson.school.tddc69.project.model;

import se.daniel_andersson.school.tddc69.project.TestStateGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceHandler {

    private ResourceHandler() {
    }

    public static BufferedImage getImage(String image) {
        try {
            File file = new File(TestStateGame.class.getResource("assets/img/"+image).getFile());
            System.out.println("Read image: " + file.getAbsolutePath());
            return ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Image " + image+ " do not exist.");
            System.exit(0);
            return null;
        }
    }

    public static File getLevelFile(String f) {
        File file = new File(TestStateGame.class.getResource("assets/level/"+f).getFile());
        if (file.exists()) {
            System.out.println("Read file: " + file.getAbsolutePath());
            return file;
        } else
            return null;
    }
}
