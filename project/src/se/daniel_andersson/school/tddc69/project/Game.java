package se.daniel_andersson.school.tddc69.project;


public class Game {

    private Player player;
    private Level currentLevel;

    public Game() {
        currentLevel = new Level(1);
        player = new Player(currentLevel.getWidth()/2);
        player.moveLeft();
        player.moveLeft();
        player.moveLeft();
        player.moveLeft();
        player.moveLeft();
        player.moveUp();
    }




    public Level getLevel() {
        return currentLevel;
    }

    public Player getPlayer() {
        return player;
    }

}
