package se.daniel_andersson.school.tddc69.project.controller;


import se.daniel_andersson.school.tddc69.project.model.Level;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

public class Game {

    private final Player player;
    private Level currentLevel;

    private int levelsCompleted;

    public Game() {
        currentLevel = new Level(1);
        player = new Player(currentLevel.getTileWidth()*currentLevel.getStartX(), currentLevel.getTileHeight()*currentLevel.getStartY());
    }

    public boolean gameOver() {
        return !player.isAlive();
    }

    public int getLevelsCompleted() {
        return levelsCompleted;
    }

    public boolean levelComplete(){
        return currentLevel.reachedEnd();
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
            if (player.collisionAble())
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
