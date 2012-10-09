package se.daniel_andersson.school.tddc69.project.model.objects;


import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.Solid;

import java.awt.image.BufferedImage;

public class Tree extends Solid{
    private static BufferedImage texture = null;

    public Tree(){
        if (texture == null)
            texture = ResourceHandler.getImage("treed.png");
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public void destroy() {
    }
}


