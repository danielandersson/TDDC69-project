package se.daniel_andersson.school.tddc69.project.controller.states;


import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class GameOverState extends State {

    /**
     * The Constant SCREEN_HEIGHT.
     */
    private static final int SCREEN_WIDTH = 1024;
    private static final int SCREEN_HEIGHT = 576;

    /**
     * The backgroundImage.
     */
    private final BufferedImage backgroundImage = ResourceHandler.getImage("gameover.png");

    /**
     * Instantiates a new help state.
     */
    public GameOverState() {
        super("GameOverState");
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


