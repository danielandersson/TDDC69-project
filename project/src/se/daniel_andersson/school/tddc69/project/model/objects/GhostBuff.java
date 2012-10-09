package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.PowerUp;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Ghost;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.image.BufferedImage;

public class GhostBuff extends PowerUp {
    private static BufferedImage texture = null;

    public GhostBuff(){
        if (texture == null)
            texture = ResourceHandler.getImage("ghost.png");
    }

    @Override
    public void collision(Player p) {
        p.setCurrentMode(new Ghost());
    }

    @Override
    public void destroy() {
    }


    @Override
    public BufferedImage getTexture() {
        return texture;
    }
}
