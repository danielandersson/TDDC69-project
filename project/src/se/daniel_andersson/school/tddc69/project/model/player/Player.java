package se.daniel_andersson.school.tddc69.project.model.player;


import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Normal;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Player {

    private int XCoord;
    private int YCoord;
    private Mode currentMode = new Normal();
    private boolean levelAdvance = false;
    private BufferedImage texture = null;
    private int life = 1;



    public Player(int XCoord, int YCoord) {
        this.XCoord = XCoord;
        this.YCoord = YCoord;
        if (texture == null)
            texture = ResourceHandler.getImage("car.png");
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public boolean isAlive() {
        return life > 0;
    }
    public void takeDamage() {
        life--;
    }

    public boolean isLevelAdvance() {
        return levelAdvance;
    }
    public void setLevelAdvance(boolean levelAdvance) {
        this.levelAdvance = levelAdvance;
    }

    public Mode getCurrentMode() {
        return currentMode;
    }
    public void setCurrentMode(Mode mode) {
        Date timeToRun = new Date(System.currentTimeMillis() + mode.getTime());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentMode = new Normal();
            }
        }, timeToRun);
        currentMode = mode;
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

    public boolean collisionAble() {
        return currentMode.collisionAble();
    }

    public int getSpeed() {
        return currentMode.getSpeed();
    }
    public int getLife() {
        return life;
    }
}
