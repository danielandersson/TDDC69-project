/*
 * 
 */
package se.daniel_andersson.school.tddc69.project;

import javax.swing.JFrame;

import se.daniel_andersson.school.tddc69.project.controller.StateManager;
import se.daniel_andersson.school.tddc69.project.view.StateFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class TestStateGame.
 */
@SuppressWarnings("serial")
public class TestStateGame extends JFrame {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new TestStateGame();
	}

    /**
	 * Instantiates a new test state game.
	 */
	public TestStateGame() {
        StateManager sm = new StateManager(new StateFrame());
		sm.setCurrentState("MenuState");
		sm.startCurrentState();
	}
}
