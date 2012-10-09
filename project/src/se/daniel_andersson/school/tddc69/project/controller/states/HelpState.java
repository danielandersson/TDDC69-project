package se.daniel_andersson.school.tddc69.project.controller.states;


import se.daniel_andersson.school.tddc69.project.model.ResourceHandler;
import se.daniel_andersson.school.tddc69.project.model.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class HelpState extends State {

    public static final int SCREEN_WIDTH = 1024, SCREEN_HEIGHT = 576;
    private BufferedImage bg = ResourceHandler.getImage("helpbg.png");

    public HelpState(){
        super("HelpState");
        screen = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        updateInputMap();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(bg, 0, 0, null);
    }


    @Override
    public void update(){
        super.update();
    }

    public Dimension getPreferredSize() {
        return new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    }

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
