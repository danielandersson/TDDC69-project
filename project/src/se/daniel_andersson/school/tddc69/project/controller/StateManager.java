/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.controller;

import se.daniel_andersson.school.tddc69.project.controller.states.*;
import se.daniel_andersson.school.tddc69.project.model.State;
import se.daniel_andersson.school.tddc69.project.model.StateChangeListener;

import javax.swing.*;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class StateManager.
 */
public class StateManager implements StateChangeListener {

	/** The states. */
	private final ArrayList<State> states;
	
	/** The current state. */
	private int currentState;
	
	/** The state frame. */
	private final JFrame stateFrame;

	/**
	 * Instantiates a new state manager.
	 *
	 * @param j the j
	 */
	public StateManager(JFrame j) {
		stateFrame = j;
		states = new ArrayList<State>();
		initAllStates();
	}

	/**
	 * Inits the all states.
	 */
	private void initAllStates() {
		// TODO Add states
		states.add(new MenuState());
		states.add(new HelpState());
		states.add(new GameState());
        states.add(new GameOverState());
        states.add(new GameCompletedState());
	}

	/**
	 * Sets the current state.
	 *
	 * @param s the new current state
	 */
	public void setCurrentState(String s) {
		for (int i = 0; i < states.size(); i++) {
			if (s.equals(states.get(i).name)) {
				currentState = i;
			}
		}
	}

	/**
	 * Start current state.
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
		System.out.println("Byte State");
		stopCurrentState();
		setCurrentState(nextState);
		states.get(currentState).updateInputMap();
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