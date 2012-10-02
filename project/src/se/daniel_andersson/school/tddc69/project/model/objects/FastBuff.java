package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.Liquid;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Fast;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;


public class FastBuff extends Liquid {

    public FastBuff(){

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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
