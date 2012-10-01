package se.daniel_andersson.school.tddc69.project;


public class Player {

    private int XCoord;
    private int YCoord;

    public boolean isLevelAdvance() {
        return levelAdvance;
    }

    public void setLevelAdvance(boolean levelAdvance) {
        this.levelAdvance = levelAdvance;
    }

    private boolean levelAdvance = false;

    private boolean alive;

    private int speed = 5;

    public Player(int XCoord, int YCoord) {
        this.XCoord = XCoord;
        this.YCoord = YCoord;
        alive = true;
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
}
