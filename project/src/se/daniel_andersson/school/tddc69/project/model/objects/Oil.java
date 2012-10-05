package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.Liquid;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.MovementDisable;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.image.BufferedImage;


public class Oil extends Liquid {

    private static BufferedImage texture = null;

    public Oil(){
        if (texture == null)
            texture = ResourceHandler.getImage("oil.png");
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public void collision(Player p) {
        p.setCurrentMode(new MovementDisable());
    }

    @Override
    public void destroy() {
    }
}
