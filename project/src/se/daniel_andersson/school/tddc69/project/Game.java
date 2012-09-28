package se.daniel_andersson.school.tddc69.project;


public class Game {

    private Player player;
    private Level currentLevel;

    public Game() {
        currentLevel = new Level(1);
        player = new Player(150);
        player.moveLeft();
        player.moveLeft();
        player.moveLeft();
        player.moveLeft();
        player.moveLeft();
        player.moveUp();
    }

    public boolean gameOver() {
        if(currentLevel.reachedEnd())
            return true;
        else
            return false;
    }

    public void gameTick() {
        currentLevel.updateLevelIndex();
    }




    public Level getLevel() {
        return currentLevel;
    }

    public Player getPlayer() {
        return player;
    }

}
