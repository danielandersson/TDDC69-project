package se.daniel_andersson.school.tddc69.project.controller.states;

import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

/**
 * The MenuState class.
 */
@SuppressWarnings("serial")
public class MenuState extends State {
	private static final int SCREEN_WIDTH = 1024;
    private static final int SCREEN_HEIGHT = 576;
	private int currentOption = 0;
	private static final int MENU_ITEMS = 3;
	private final BufferedImage backgroundImage = ResourceHandler.getImage("menubg.jpg");
	private final BufferedImage logo = ResourceHandler.getImage("logo.png");

	/**
	 * Instantiates a new menu state.
	 */
	public MenuState() {
		super("MenuState");
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
		g2.drawImage(backgroundImage, 0, 0, null);
		g2.drawImage(logo, 100, 100, null);
		paintMenu(g2);
	}

	/**
	 * Paint menu.
	 *
	 * @param g2 the Graphics2D
	 */
	private void paintMenu(Graphics2D g2) {
        // In this method there is a lot of magic numbers due to the positioning of the menu. sorry :(
		int intPosX = 800, intPosY = 300;
        int menuItemWidth = 160, menuItemHeight = 40;
        int menuItemSpace = 60, menuStringXPadding = 28, menuStringYPadding = 15;

		g2.setFont(new Font("Corial", Font.PLAIN, 24));
		g2.setColor(new Color(0, 0, 0, 100));

        for (int i = 0; i < MENU_ITEMS; i++) {
            g2.fillRect(intPosX, intPosY + (i*menuItemSpace), menuItemWidth, menuItemHeight);
        }
        g2.setColor(Color.BLACK);
        g2.fillRect(intPosX, intPosY + (menuItemSpace*currentOption), menuItemWidth, menuItemHeight);
		if (currentOption == 0) {
			g2.setColor(Color.WHITE);
			g2.drawString("New Game", intPosX + menuStringYPadding, intPosY + (menuItemSpace*currentOption) + menuStringXPadding);
		} else if (currentOption == 1) {
			g2.setColor(Color.WHITE);
			g2.drawString("How to play?", intPosX + menuStringYPadding, intPosY + (menuItemSpace*currentOption) + menuStringXPadding);
		} else if (currentOption == 2) {
			g2.setColor(Color.WHITE);
			g2.drawString("Exit", intPosX + menuStringYPadding, intPosY + (menuItemSpace*currentOption) + menuStringXPadding);
		}
		g2.setColor(new Color(255, 255, 255, 100));
		g2.drawString("New Game", intPosX + menuStringYPadding, intPosY + 0*menuItemSpace + menuStringXPadding);
		g2.drawString("How to play?", intPosX + menuStringYPadding, intPosY + 1*menuItemSpace + menuStringXPadding);
		g2.drawString("Exit", intPosX + menuStringYPadding, intPosY + 2*menuItemSpace + menuStringXPadding);
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
		final Action menuUp = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentOption > 0)
					currentOption--;
			}
		};
		final Action menuDown = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentOption < MENU_ITEMS - 1)
					currentOption++;
			}
		};
		final Action menuPress = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentOption == 0)
					getListener().stateChanged("GameState");
				else if (currentOption == 1)
					getListener().stateChanged("HelpState");
				else if (currentOption == 2)
					System.exit(0);
			}
		};
		super.getInputMap().put(KeyStroke.getKeyStroke("UP"), "menuUp");
		super.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "menuDown");
		super.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "menuPress");
		super.getActionMap().put("menuUp", menuUp);
		super.getActionMap().put("menuDown", menuDown);
		super.getActionMap().put("menuPress", menuPress);
	}
}
