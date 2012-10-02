package se.daniel_andersson.school.tddc69.project.controller;


import se.daniel_andersson.school.tddc69.project.model.Level;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

public class Game {

    private Player player;
    private Level currentLevel;

    private int levelsCompleted;

    public Game() {
        currentLevel = new Level(1);
        player = new Player(currentLevel.getTileWidth()*currentLevel.getStartX(), currentLevel.getTileHeight()*currentLevel.getStartY());
    }

    public boolean gameOver() {
        if(player.isAlive())
            return false;
        else
            return true;
    }

    public int getLevelsCompleted() {
        return levelsCompleted;
    }

    public boolean levelComplete(){
        if(currentLevel.reachedEnd())
            return true;
        else
            return false;
    }

    public void gameTick() {
        if (player.isLevelAdvance()) {
            levelsCompleted++;
            currentLevel = new Level(2);
            player.setXCoord(currentLevel.getTileWidth()*currentLevel.getStartX());
            player.setYCoord(currentLevel.getTileHeight()*currentLevel.getStartY());
            player.setLevelAdvance(false);
        }
        else {
            currentLevel.collision(player);
            if (!levelComplete())
                currentLevel.updateLevelIndex();
        }
    }

    public Level getLevel() {
        return currentLevel;
    }

    public Player getPlayer() {
        return player;
    }

}
