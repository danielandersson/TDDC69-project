package se.daniel_andersson.school.tddc69.project.model.player;


import se.daniel_andersson.school.tddc69.project.model.player.Modes.Fast;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Ghost;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Normal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Player {

    private int XCoord;
    private int YCoord;

    public Mode getCurrentMode() {
        return currentMode;
    }
    public void setCurrentMode(Mode mode) {
        currentMode = mode;
    }

    private Mode currentMode = new Normal();

    private boolean levelAdvance = false;
    private boolean alive;

    public int getSpeed() {
        return speed;
    }

    private int speed = 5;

    private BufferedImage texture = null;



    public Player(int XCoord, int YCoord) {
        this.XCoord = XCoord;
        this.YCoord = YCoord;
        alive = true;

        try {
            File file = new File(getClass().getResource("../../img/car.png").getFile());
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

    public boolean isLevelAdvance() {
        return levelAdvance;
    }
    public void setLevelAdvance(boolean levelAdvance) {
        this.levelAdvance = levelAdvance;
    }

    public int getXCoord() {
        return XCoord;
    }
    public int getYCoord() {
        return YCoord;
    }
    public void setXCoord(int XCoord) {
        this.XCoord = XCoord;
    }

    public void setYCoord(int YCoord) {
        this.YCoord = YCoord;
    }
    public void moveUp() {
        currentMode.moveUp(this);
    }
    public void moveRight() {
        currentMode.moveRight(this);
    }
    public void moveDown() {
        currentMode.moveDown(this);
    }
    public void moveLeft() {
        currentMode.moveLeft(this);
    }
}
