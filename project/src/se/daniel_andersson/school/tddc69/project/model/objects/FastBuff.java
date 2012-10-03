package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.Liquid;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Fast;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FastBuff extends Liquid {
    private BufferedImage texture = null;

    public FastBuff(){
        try {
            File file = new File(getClass().getResource("../../img/speed.png").getFile());
            texture = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("You failed.");
        }
    }

    @Override
    public void collision(Player object) {
        object.setCurrentMode(new Fast());
    }

    @Override
    public void destroy() {
    }

    @Override
    public Color paintColor() {
        return Color.ORANGE;
    }

    @Override
    public BufferedImage getTexture() {
        return texture;
    }

}
