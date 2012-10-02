package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.GameObject;
import se.daniel_andersson.school.tddc69.project.model.Liquid;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Oil extends Liquid {

    private BufferedImage texture = null;

    public Oil(){
        try {
            File file = new File(getClass().getResource("../../img/oil.png").getFile());
            texture = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("You failed.");
        }
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public void collision(Player object) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public Color paintColor() {
        return Color.BLACK;
    }

}