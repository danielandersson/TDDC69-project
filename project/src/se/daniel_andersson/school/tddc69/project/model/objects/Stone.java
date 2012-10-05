package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.Solid;

import java.awt.image.BufferedImage;

public class Stone extends Solid {
    private static BufferedImage texture = null;

    public Stone(){
        if (texture == null)
            texture = ResourceHandler.getImage("stone.png");
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public void destroy() {
    }
}
