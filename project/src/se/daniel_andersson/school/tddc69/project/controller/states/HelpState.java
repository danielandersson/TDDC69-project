/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.controller.states;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.State;

// TODO: Auto-generated Javadoc
/**
 * The Class HelpState.
 */
@SuppressWarnings("serial")
public class HelpState extends State {

	/** The Constant SCREEN_HEIGHT. */
	public static final int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 576;
	
	/** The bg. */
	private BufferedImage bg = ResourceHandler.getImage("helpbg.png");

	/**
	 * Instantiates a new help state.
	 */
	public HelpState() {
		super("HelpState");
		screen = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		updateInputMap();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bg, 0, 0, null);
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.State#update()
	 */
	@Override
	public void update() {
		super.update();
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.State#updateInputMap()
	 */
	@Override
	public void updateInputMap() {
		System.out.println("Uppdaterar Inputs");
		final Action enterPress = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getListener().stateChanged("MenuState");
			}
		};
		super.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterPress");
		super.getActionMap().put("enterPress", enterPress);
	}
}
