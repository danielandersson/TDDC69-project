package se.daniel_andersson.school.tddc69.project;

import se.daniel_andersson.school.tddc69.project.controller.StateManager;
import se.daniel_andersson.school.tddc69.project.view.StateFrame;

import javax.swing.*;

/**
 * This is the main class for the project.s
 */
@SuppressWarnings("serial")
public class TestStateGame extends JFrame {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
        StateManager sm = new StateManager(new StateFrame());
        sm.setCurrentState("MenuState");
        sm.startCurrentState();
	}

}
