package se.daniel_andersson.school.tddc69.project.model;


import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.image.BufferedImage;

public abstract interface GameObject {

    public abstract void collision(Player object);
    public abstract void destroy();
    public abstract BufferedImage getTexture();

}
