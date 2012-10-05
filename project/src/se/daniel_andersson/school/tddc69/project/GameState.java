package se.daniel_andersson.school.tddc69.project;

import se.daniel_andersson.school.tddc69.project.controller.Game;
import se.daniel_andersson.school.tddc69.project.view.GraphicalStateViewer;

import java.awt.*;


public class GameState extends State {

    Game mainGame;
    GraphicalStateViewer graphicalStateViewer;
    long prevTimer;

    public GameState() {
        super("GameState");
        mainGame = new Game();
        graphicalStateViewer = new GraphicalStateViewer(mainGame);
    }

    @Override
    public void render() {
        Graphics2D g2 = getGraphics2D();
        g2.setColor(Color.RED);
        g2.drawString("This is the game", 120, 120);
        graphicalStateViewer.paintComponent(g2);
        super.render();
    }

    public void update(){
        if (prevTimer+100 < System.currentTimeMillis()) {
            super.update();
            mainGame.gameTick();
            prevTimer = System.currentTimeMillis();
        }
    }

}
