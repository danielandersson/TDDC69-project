package se.daniel_andersson.school.tddc69.project.view;

import javax.swing.*;

/**
 * This is main JFrame for all the states. Each state will draw it self to this frame.
 */
@SuppressWarnings("serial")
public class StateFrame extends JFrame {

	/**
	 * Instantiates a new state frame.
	 */
	public StateFrame() {
		super("DV RACING");
		super.setUndecorated(true);
		super.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
