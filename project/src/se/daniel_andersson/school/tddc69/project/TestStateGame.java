package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.awt.Graphics;

public class TestStateGame extends JFrame{


    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    StateManager sm;

    public TestStateGame(){
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
    }

    private void init(){
        sm = new StateManager(this);
        sm.setCurrentState("GameState");
        sm.startCurrentState();
    }
    /*
    public TestStateGame() {
        sm = new StateManager(new StateFrame());
        sm.setCurrentState("GameState");
        sm.startCurrentState();
    }*/



    public static void main(String[] args) {
        TestStateGame main = new TestStateGame();
    }
}
