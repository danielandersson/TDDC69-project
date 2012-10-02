package se.daniel_andersson.school.tddc69.project.model;


import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    public abstract void collision(Player object);
    public abstract void destroy();

    // TODO Remove paintColor when all objects have textures
    public abstract Color paintColor();
    public abstract BufferedImage getTexture();

}
