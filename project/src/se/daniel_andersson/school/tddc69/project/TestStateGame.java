package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;

public class TestStateGame extends JFrame{


    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    StateManager sm;


    public TestStateGame() {
        sm = new StateManager(new StateFrame());
        sm.setCurrentState("GameState");
        sm.startCurrentState();
    }



    public static void main(String[] args) {
        TestStateGame main = new TestStateGame();
    }
}
