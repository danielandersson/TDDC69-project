package se.daniel_andersson.school.tddc69.project;


import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    public abstract void collision(Player p);

    public abstract Color paintColor();
    public abstract BufferedImage getTexture();

}
