package se.daniel_andersson.school.tddc69.project.model.player.Modes;


import se.daniel_andersson.school.tddc69.project.model.player.Mode;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

public class MovementDisable implements Mode {

    private final int time = 5000;
    private final int speed = 0;
    @Override
    public void moveRight(Player p) {
    }
    @Override
    public void moveLeft(Player p) {
    }
    @Override
    public void moveUp(Player p) {
    }
    @Override
    public void moveDown(Player p) {
    }
    @Override
    public boolean collisionAble() {
        return true;
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
