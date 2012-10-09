package se.daniel_andersson.school.tddc69.project;


import se.daniel_andersson.school.tddc69.project.controller.Game;
import se.daniel_andersson.school.tddc69.project.view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TestGame {


    private TestGame() {
    }

    public static void main(String[] args) {
        final Game mainGame = new Game();
        final GameFrame gameFrame = new GameFrame(mainGame);
        gameFrame.setVisible(true);

        final Timer clockTimer;
        final Action doOneStep = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!mainGame.gameOver())
                    mainGame.gameTick();
                gameFrame.repaint();
            }
        };
        clockTimer = new Timer(100, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();
    }
}
