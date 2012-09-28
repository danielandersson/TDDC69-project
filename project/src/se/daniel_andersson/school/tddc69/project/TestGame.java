package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class TestGame {

    public static void main(String[] args) {
        final Game mainGame = new Game();
        final GameFrame gameFrame = new GameFrame(mainGame);
        gameFrame.setVisible(true);

        final Timer clockTimer;
        final Action doOneStep = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.rePaint();
            }
        };
        clockTimer = new Timer(10, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();
    }
}
