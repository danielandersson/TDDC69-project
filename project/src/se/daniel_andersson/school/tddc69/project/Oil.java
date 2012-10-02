package se.daniel_andersson.school.tddc69.project;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Oil extends Liquid {

    private BufferedImage texture = null;

    public Oil(){
        try {
            File file = new File(getClass().getResource("img/oil.png").getFile());
            texture = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("You failed.");
        }
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public Color paintColor() {
        return Color.BLACK;
    }

}
