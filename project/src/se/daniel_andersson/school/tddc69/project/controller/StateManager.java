package se.daniel_andersson.school.tddc69.project.controller;

import se.daniel_andersson.school.tddc69.project.controller.states.*;
import se.daniel_andersson.school.tddc69.project.model.State;
import se.daniel_andersson.school.tddc69.project.model.StateChangeListener;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The StateManager class. This class is managing all the states and switches between them.
 */
public class StateManager implements StateChangeListener {

	private final ArrayList<State> states;
	private int currentState;
	private final JFrame stateFrame;

	/**
	 * Instantiates a new state manager.
	 *
	 * @param j the JFrame we uses for draw the stats
	 */
	public StateManager(JFrame j) {
		stateFrame = j;
		states = new ArrayList<State>();
		initAllStates();
	}

	/**
	 * Initialize the all states.
	 */
	private void initAllStates() {
		// Here is where we add all the states to the manager.
		states.add(new MenuState());
		states.add(new HelpState());
		states.add(new GameState());
        states.add(new GameOverState());
        states.add(new GameCompletedState());
	}

	/**
	 * Sets the current state.
	 *
	 * @param s the name of the new current state
	 */
	public void setCurrentState(String s) {
		for (int i = 0; i < states.size(); i++) {
			if (s.equals(states.get(i).name)) {
				currentState = i;
			}
		}
	}

	/**
	 * Start current state. Also resets the size of the frame to match the new state.
	 */
	public void startCurrentState() {
		stateFrame.add(states.get(currentState));
		states.get(currentState).start();
		states.get(currentState).setListener(this);
		stateFrame.pack();
		stateFrame.setLocationRelativeTo(null);
		stateFrame.setVisible(true);
		states.get(currentState).requestFocus();
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.StateChangeListener#stateChanged(java.lang.String)
	 */
	@Override
	public void stateChanged(String nextState) {
		stopCurrentState();
		setCurrentState(nextState);
		startCurrentState();
	}

	/**
	 * Stop current state.
	 */
    void stopCurrentState() {
		stateFrame.remove(states.get(currentState));
		states.get(currentState).stop();
	}
}