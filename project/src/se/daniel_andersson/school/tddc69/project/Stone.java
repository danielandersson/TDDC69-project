package se.daniel_andersson.school.tddc69.project;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Stone extends Solid {
    private BufferedImage texture = null;

    public Stone(){
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public Color paintColor() {
        return Color.GRAY;
    }
}
