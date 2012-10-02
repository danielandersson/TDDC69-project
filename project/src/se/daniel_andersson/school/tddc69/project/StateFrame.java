package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;

public class StateFrame extends JFrame {

    public StateFrame() {
        setSize(TestStateGame.GAME_WIDTH, TestStateGame.GAME_HEIGHT);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
