package se.daniel_andersson.school.tddc69.project.model.player.Modes;


import se.daniel_andersson.school.tddc69.project.model.player.Mode;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

public class Fast implements Mode {
    @Override
    public void moveRight(Player p) {
        if (p.isAlive())
            p.setXCoord(p.getXCoord() + 2*p.getSpeed());
    }
    @Override
    public void moveLeft(Player p) {
        if (p.isAlive())
            p.setXCoord(p.getXCoord() - 2*p.getSpeed());
    }
    @Override
    public void moveUp(Player p) {
        if (p.isAlive())
            p.setYCoord(p.getYCoord() + 2*p.getSpeed());
    }
    @Override
    public void moveDown(Player p) {
        if (p.isAlive())
            p.setYCoord(p.getYCoord() - 2*p.getSpeed());
    }
}
