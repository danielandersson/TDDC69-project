package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;

public class StateFrame extends JFrame {

    public StateFrame() {
        super("Project");
        //super.setUndecorated(true);
        super.setSize(TestStateGame.GAME_WIDTH, TestStateGame.GAME_HEIGHT);
        super.setResizable(false);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
    }
}
