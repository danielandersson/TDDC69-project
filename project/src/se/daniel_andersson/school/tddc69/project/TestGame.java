package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;

public class TestGame {

    public static void main(String[] args) {
        final Game mainGame = new Game();
        final GameFrame gameFrame = new GameFrame(mainGame);
        gameFrame.setVisible(true);
    }
}
