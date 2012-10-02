package se.daniel_andersson.school.tddc69.project;


import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelPortal extends GameObject {
    private BufferedImage texture = null;

    public LevelPortal() {
    }

    @Override
    public void collision(Player p) {
        p.setLevelAdvance(true);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public Color paintColor() {
        return Color.CYAN;
    }
}
