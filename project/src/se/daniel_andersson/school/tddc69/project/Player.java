package se.daniel_andersson.school.tddc69.project;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private int XCoord;
    private int YCoord;


    private boolean levelAdvance = false;
    private boolean alive;
    private int speed = 5;

    private BufferedImage texture = null;


    public Player(int XCoord, int YCoord) {
        this.XCoord = XCoord;
        this.YCoord = YCoord;
        alive = true;

        try {
            File file = new File(getClass().getResource("img/car.png").getFile());
            texture = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("You failed.");
        }
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public boolean isAlive() {
        return alive;
    }
    public void die() {
        alive = false;
    }
    public int getXCoord() {
        return XCoord;
    }
    public int getYCoord() {
        return YCoord;
    }
    public void moveRight() {
        if (isAlive())
            XCoord = XCoord + speed;
    }
    public void moveLeft() {
        if (isAlive())
            XCoord = XCoord - speed;
    }
    public void moveUp() {
        if (isAlive())
            YCoord = YCoord + speed;
    }
    public void moveDown() {
        if (isAlive())
            YCoord = YCoord - speed;
    }
    public boolean isLevelAdvance() {
        return levelAdvance;
    }
    public void setLevelAdvance(boolean levelAdvance) {
        this.levelAdvance = levelAdvance;
    }
}
