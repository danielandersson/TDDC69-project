package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.PowerUp;
import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Fast;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.awt.image.BufferedImage;


public class FastBuff extends PowerUp {
    private static BufferedImage texture = null;

    public FastBuff(){
        if (texture == null)
            texture = ResourceHandler.getImage("speed.png");
    }

    @Override
    public void collision(Player p) {
        p.setCurrentMode(new Fast());
    }

    @Override
    public void destroy() {
    }


    @Override
    public BufferedImage getTexture() {
        return texture;
    }

}
