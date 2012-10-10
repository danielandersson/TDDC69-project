/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.Timer;

// TODO: Auto-generated Javadoc
/**
 * The Class State.
 */
@SuppressWarnings("serial")
public class State extends JComponent implements Runnable {

	/** The running. */
	private volatile boolean running = false;

	/** The ticks. */
	private long ticks = 0;
	
	/** The screen. */
	public BufferedImage screen;
	
	/** The g. */
	private Graphics2D g;

	/** The name. */
	public String name;

	/** The listener. */
	private StateChangeListener listener = null;

	/** The render task. */
	ActionListener renderTask = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			repaint();
		}
	};

	/**
	 * Instantiates a new state.
	 *
	 * @param s the s
	 */
	public State(String s) {
		name = s;
	}

	/**
	 * Gets the graphics2 d.
	 *
	 * @return the graphics2 d
	 */
	public Graphics2D getGraphics2D() {
		g = screen.createGraphics();
		return g;
	}

	/**
	 * Gets the listener.
	 *
	 * @return the listener
	 */
	public StateChangeListener getListener() {
		return listener;
	}

	/**
	 * Gets the ticks.
	 *
	 * @return the ticks
	 */
	public long getTicks() {
		return ticks;
	}

	/**
	 * Checks if is running.
	 *
	 * @return true, if is running
	 */
	public boolean isRunning() {
		return running;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Timer renderTimer = new Timer(10, renderTask);
		renderTimer.start();
		while (running) {
			update();
		}
	}

	/**
	 * Sets the listener.
	 *
	 * @param listener the new listener
	 */
	public void setListener(StateChangeListener listener) {
		this.listener = listener;
	}

	/*
	 * public void render(){ Graphics g = null; try { g = getGraphics();
	 * g.setColor(Color.GRAY); g.drawImage(screen, 0, 0, screen.getWidth(),
	 * screen.getHeight(), this); } catch (NullPointerException e) {
	 * System.out.println("NEJ!"); //e.printStackTrace(); } //repaint(); }
	 */

	/**
	 * Start.
	 */
	public void start() {
		if (!running) {
			running = true;
			new Thread(this).start();
		}
	}

	/**
	 * Stop.
	 */
	public void stop() {
		if (running) {
			running = !running;
		}
	}

	/**
	 * Update.
	 */
	public void update() {
		ticks++;
	}

	/**
	 * Update input map.
	 */
	public void updateInputMap() {
	}
}
