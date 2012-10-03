package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.Solid;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stone extends Solid {
    private BufferedImage texture = null;

    public Stone(){
        try {
            File file = new File(getClass().getResource("../../img/stone.png").getFile());
            texture = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("You failed.");
        }
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public void destroy() {
    }

    @Override
    public Color paintColor() {
        return Color.GRAY;
    }
}
