package se.daniel_andersson.school.tddc69.project;

import se.daniel_andersson.school.tddc69.project.controller.Game;
import se.daniel_andersson.school.tddc69.project.view.GraphicalViewer;

import java.awt.*;


public class GameState extends State {

    Game mainGame;
    GraphicalViewer graphicalViewer;
    long prevTimer;

    public GameState() {
        super("GameState");
        mainGame = new Game();
        graphicalViewer = new GraphicalViewer(mainGame);
    }

    @Override
    public void render() {
        Graphics2D g2 = getGraphics2D();
        g2.setColor(Color.RED);
        g2.drawString("This is the game", 120, 120);
        graphicalViewer.paintComponent(g2);
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
