package se.daniel_andersson.school.tddc69.project;

import se.daniel_andersson.school.tddc69.project.controller.Game;
import se.daniel_andersson.school.tddc69.project.view.GraphicalStateViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;


public class GameState extends State {

    Game mainGame;
    GraphicalStateViewer graphicalStateViewer;
    long prevTimer;

    public GameState() {
        super("GameState");
        mainGame = new Game();
        graphicalStateViewer = new GraphicalStateViewer(mainGame);
        screen = new BufferedImage(graphicalStateViewer.getPreferredSize().width, graphicalStateViewer.getPreferredSize().height, BufferedImage.TYPE_INT_RGB);
        updateInputMap();
    }

    @Override
    public void render() {
        Graphics2D g2 = getGraphics2D();
        //System.out.println(mainGame.getLevel().getBgColor());
        //System.out.println(Integer.parseInt(mainGame.getLevel().getBgColor(), 16));
        g2.setColor(new Color(Integer.parseInt(mainGame.getLevel().getBgColor(), 16)));
        g2.setColor(Color.BLACK);
        g2.fill(this.getBounds());
        graphicalStateViewer.paintComponent(g2);
        super.render();
    }

    public void update(){
        if (prevTimer+90 < System.currentTimeMillis()) {
            super.update();
            mainGame.gameTick();
            prevTimer = System.currentTimeMillis();
        }
    }
    public Dimension getPreferredSize() {
        return new Dimension(graphicalStateViewer.getPreferredSize());
    }

    public void updateInputMap() {
        System.out.println("Uppdaterar Inputs");

        final Action moveUp = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainGame.getPlayer().getYCoord()+mainGame.getPlayer().getSpeed() < mainGame.getLevel().getScreenHeight()*mainGame.getLevel().getTileHeight())
                    mainGame.getPlayer().moveUp();
            }
        };
        final Action moveLeft = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainGame.getPlayer().getXCoord() > 0)
                    mainGame.getPlayer().moveLeft();
            }
        };
        final Action moveRight = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainGame.getPlayer().getXCoord() < mainGame.getLevel().getLevelWidth()*mainGame.getLevel().getTileWidth()-mainGame.getLevel().getTileWidth())
                    mainGame.getPlayer().moveRight();
            }
        };
        final Action moveDown = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainGame.getPlayer().getYCoord() > mainGame.getLevel().getTileHeight())
                    mainGame.getPlayer().moveDown();
            }
        };


        super.getInputMap().put(KeyStroke.getKeyStroke("UP"), "moveUp");
        super.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        super.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        super.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        super.getActionMap().put("moveUp", moveUp);
        super.getActionMap().put("moveLeft", moveLeft);
        super.getActionMap().put("moveRight", moveRight);
        super.getActionMap().put("moveDown", moveDown);
    }
}
