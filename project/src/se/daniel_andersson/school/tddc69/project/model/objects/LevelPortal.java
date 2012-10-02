package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.GameObject;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelPortal extends GameObject {
    private BufferedImage texture = null;

    public LevelPortal() {
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public void collision(Player object) {
        object.setLevelAdvance(true);
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Color paintColor() {
        return Color.CYAN;
    }
}
