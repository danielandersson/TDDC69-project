package se.daniel_andersson.school.tddc69.project.model.player;


import se.daniel_andersson.school.tddc69.project.model.player.Modes.Fast;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Ghost;
import se.daniel_andersson.school.tddc69.project.model.player.Modes.Normal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Player {

    private int XCoord;
    private int YCoord;
    private Mode currentMode = new Normal();
    private boolean levelAdvance = false;
    private int speed = 5;
    private BufferedImage texture = null;
    private int life;



    public Player(int XCoord, int YCoord) {
        this.XCoord = XCoord;
        this.YCoord = YCoord;
        life = 5;

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

    public int getSpeed() {
        return speed;
    }
    public int getLife() {
        return life;
    }
}
