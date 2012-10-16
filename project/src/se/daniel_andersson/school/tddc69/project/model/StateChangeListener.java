package se.daniel_andersson.school.tddc69.project.model;

/**
 *  This inteface is used as a switch between states.
 */
public interface StateChangeListener {
	
	/**
	 * State changed.
	 *
	 * @param nextState which state we want to start.
	 */
	public void stateChanged(String nextState);
}
