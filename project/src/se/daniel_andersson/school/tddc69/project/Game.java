package se.daniel_andersson.school.tddc69.project;


public class Game {

    private Player player;
    private Level currentLevel;

    public int getLevelsCompleted() {
        return levelsCompleted;
    }

    private int levelsCompleted;

    public Game() {
        currentLevel = new Level(1);
        player = new Player((currentLevel.getTileWidth()*currentLevel.getLevelWidth())/2 - currentLevel.getTileWidth()/2, currentLevel.getTileHeight());
    }

    public boolean gameOver() {
        if(player.isAlive())
            return false;
        else
            return true;
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
            currentLevel = new Level(1);
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
