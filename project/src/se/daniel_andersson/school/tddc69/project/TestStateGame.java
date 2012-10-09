package se.daniel_andersson.school.tddc69.project;


import se.daniel_andersson.school.tddc69.project.controller.StateManager;
import se.daniel_andersson.school.tddc69.project.view.StateFrame;

import javax.swing.*;

public class TestStateGame extends JFrame {

    public StateManager sm;


    public TestStateGame() {
        sm = new StateManager(new StateFrame());
        sm.setCurrentState("MenuState");
        sm.startCurrentState();
    }

    public static void main(String[] args) {
        TestStateGame main = new TestStateGame();
    }
}
