/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving stateChange events.
 * The class that is interested in processing a stateChange
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addStateChangeListener<code> method. When
 * the stateChange event occurs, that object's appropriate
 * method is invoked.
 *
 * @see StateChangeEvent
 */
public interface StateChangeListener {
	
	/**
	 * State changed.
	 *
	 * @param nextState the next state
	 */
	public void stateChanged(String nextState);
}
