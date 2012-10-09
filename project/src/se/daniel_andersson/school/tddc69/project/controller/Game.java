package se.daniel_andersson.school.tddc69.project.controller;


import se.daniel_andersson.school.tddc69.project.model.Level;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

public class Game {

    private final Player player;
    private Level currentLevel;
    private boolean gameCompleted;

    private int levelsCompleted;

    public Game() {
        currentLevel = new Level(1);
        player = new Player(currentLevel.getTileWidth()*currentLevel.getStartX(), currentLevel.getTileHeight()*currentLevel.getStartY());
    }

    public boolean isGameCompleted() {
        return gameCompleted;
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
            if (currentLevel.getNextLevel() == 0)
                gameCompleted = true;
            else {
                currentLevel = new Level(currentLevel.getNextLevel());
                player.setXCoord(currentLevel.getTileWidth()*currentLevel.getStartX());
                player.setYCoord(currentLevel.getTileHeight()*currentLevel.getStartY());
                player.setLevelAdvance(false);
            }
        }
        else {
            if (player.collisionAble()) {
                int prevLife = player.getLife();
                currentLevel.collision(player);
                if (player.getLife() != prevLife) {
                    currentLevel = new Level(currentLevel.getID());
                    player.setXCoord(currentLevel.getTileWidth()*currentLevel.getStartX());
                    player.setYCoord(currentLevel.getTileHeight()*currentLevel.getStartY());
                }
            }
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
