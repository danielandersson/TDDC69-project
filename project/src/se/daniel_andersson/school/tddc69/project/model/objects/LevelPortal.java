package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.GameObject;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.image.BufferedImage;

public class LevelPortal implements GameObject {
    private static BufferedImage texture = null;

    public LevelPortal() {
        if (texture == null)
            texture = ResourceHandler.getImage("powerup.png");
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public void collision(Player p) {
        p.setLevelAdvance(true);
    }

    @Override
    public void destroy() {
    }

}
