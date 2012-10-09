package se.daniel_andersson.school.tddc69.project.model.player;


import java.awt.image.BufferedImage;

public interface Mode {
    public void moveRight(Player p);
    public void moveLeft(Player p);
    public void moveUp(Player p);
    public void moveDown(Player p);
    public boolean collisionAble();
    public int getSpeed();
    public int getTime();
    public BufferedImage getTexture();
}
