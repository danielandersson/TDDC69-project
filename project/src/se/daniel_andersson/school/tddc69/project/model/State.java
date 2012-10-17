package se.daniel_andersson.school.tddc69.project.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An superclass for all the different states.
 */
@SuppressWarnings("serial")
public abstract class State extends JComponent implements Runnable {

	private volatile boolean running = false;
	private long ticks = 0; // Useless now but can be useful in the future.
	public final String name;
	private StateChangeListener listener = null;

	/**
	 * Instantiates a new state.
	 *
	 * @param s the name of the state
	 */
    protected State(String s) {
		name = s;
	}

	/**
	 * Gets the state change listener.
	 *
	 * @return the listener
	 */
    protected StateChangeListener getListener() {
		return listener;
	}

    /**
     * Sets the listener.
     *
     * @param listener the new listener
     */
    public void setListener(StateChangeListener listener) {
        this.listener = listener;
    }

	/**
	 * Gets the ticks.
	 *
	 * @return the number of ticks
	 */
    @SuppressWarnings("unused")
	public long getTicks() {
		return ticks;
	}

	/**
	 * Checks if the state is running.
	 *
	 * @return true, if is running
	 */
    @SuppressWarnings("unused")
	public boolean isRunning() {
		return running;
	}

    /**
     *  A new action listener for the timed repaint.
     *
     */
    private final ActionListener renderTask = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            repaint();
        }
    };

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Timer renderTimer = new Timer(10, renderTask); // 10 ms gives us ~100 FPS.
		renderTimer.start();
		while (running) {
			update();
		}
	}

	/**
	 * Start the current state.
	 */
	public void start() {
		if (!running) {
			running = true;
			new Thread(this).start();
		}
        updateInputMap();
	}

	/**
	 * Stop the current state.
	 */
	public void stop() {
		if (running) {
			running = !running;
		}
	}

	/**
	 * Update the current state.
	 */
    protected void update() {
		ticks++;
	}

	/**
	 * Update input map with new inputs.
	 */
	public abstract void updateInputMap();
}
