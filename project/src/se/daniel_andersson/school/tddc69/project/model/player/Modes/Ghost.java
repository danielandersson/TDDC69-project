package se.daniel_andersson.school.tddc69.project.model.player.Modes;


import se.daniel_andersson.school.tddc69.project.model.player.Mode;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

public class Ghost implements Mode {
    private final int time = 5000;
    private final int speed = 5;
    @Override
    public void moveRight(Player p) {
        if (p.isAlive())
            p.setXCoord(p.getXCoord() + speed);
    }
    @Override
    public void moveLeft(Player p) {
        if (p.isAlive())
            p.setXCoord(p.getXCoord() - speed);
    }
    @Override
    public void moveUp(Player p) {
        if (p.isAlive())
            p.setYCoord(p.getYCoord() + speed);
    }
    @Override
    public void moveDown(Player p) {
        if (p.isAlive())
            p.setYCoord(p.getYCoord() - speed);
    }
    @Override
    public boolean collisionAble() {
        return false;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getTime() {
        return time;
    }
}
