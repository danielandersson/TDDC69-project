package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class MenuState extends State {

    public static final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;
    private int currentOption = 0;

    public MenuState(){
        super("MenuState");
        screen = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        updateInputMap();
    }

    @Override
    public void render(){
        Graphics2D g = getGraphics2D();
        g.setColor(Color.red);
        g.fillRect(100, 100, 100, 100);
        g.setColor(Color.white);
        g.drawString("This is the menu state", 120, 120);
        g.drawString("Option: " + currentOption, 120, 140);
        super.render();
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
        final Action menuUp = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOption--;
            }
        };
        final Action menuDown = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOption++;
            }
        };
        final Action menuPress = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getListener().stateChanged("GameState");
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
