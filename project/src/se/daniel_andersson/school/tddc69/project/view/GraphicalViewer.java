package se.daniel_andersson.school.tddc69.project.view;


import se.daniel_andersson.school.tddc69.project.controller.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GraphicalViewer extends JComponent {
    public static int WIDTH;

    public static int HEIGHT;

    private Game mainGame;



    public GraphicalViewer(Game mainGame) {
        this.mainGame = mainGame;
        HEIGHT = mainGame.getLevel().getScreenHeight() * mainGame.getLevel().getTileHeight();
        WIDTH = mainGame.getLevel().getLevelWidth() * mainGame.getLevel().getTileWidth();
    }

    private void paintPlayer(final Graphics2D g2) {
        g2.setColor(Color.PINK);
        int XMath = mainGame.getPlayer().getXCoord();
        int YMath = HEIGHT - (mainGame.getPlayer().getYCoord()+1);
        g2.drawImage(mainGame.getPlayer().getTexture(), XMath, YMath, mainGame.getLevel().getTileWidth(), mainGame.getLevel().getTileHeight(), null);
    }

    private void paintMap(final Graphics2D g2) {
        int k = 0;
        if (mainGame.getLevel().getTopIndex() > 0)
            k = 1;
        for (int i = mainGame.getLevel().getTopIndex()-k; i <= mainGame.getLevel().getBottomIndex(); i++) {
            for (int j = 0; j < mainGame.getLevel().getLevelWidth(); j++) {
                int XMath = mainGame.getLevel().getTileWidth()*j;
                int YMath = mainGame.getLevel().getTileHeight()*(i-mainGame.getLevel().getTopIndex())+mainGame.getLevel().getInnerTile();
                if (mainGame.getLevel().getMap()[i][j] != null) {
                    if (mainGame.getLevel().getMap()[i][j].getClass().toString().contains("Oil")) {
                        g2.drawImage(mainGame.getLevel().getMap()[i][j].getTexture(), XMath, YMath, mainGame.getLevel().getTileWidth(), mainGame.getLevel().getTileHeight(), null);
                    } else {
                        g2.setColor(mainGame.getLevel().getMap()[i][j].paintColor());
                        g2.fill(new Rectangle2D.Double(XMath, YMath, mainGame.getLevel().getTileWidth(), mainGame.getLevel().getTileHeight()));
                    }
                }
            }
        }
    }

    private void paintDebug(final Graphics2D g2) {
        int XMath = mainGame.getPlayer().getXCoord();
        int YMath = mainGame.getPlayer().getYCoord()-mainGame.getLevel().getTopIndex();
        g2.setColor(Color.BLACK);
        g2.drawString("Player X: " + mainGame.getPlayer().getXCoord() + " Relative: " + XMath, 5, 15);
        g2.drawString("Player Y: " + mainGame.getPlayer().getYCoord() + " Relative: " + YMath, 5, 25);
        g2.drawString("Player Mode: " + mainGame.getPlayer().getCurrentMode().getClass().getSimpleName(), 5, 35);

        g2.drawString("MapSize: H:" + mainGame.getLevel().getLevelHeight() + " W:" + mainGame.getLevel().getLevelWidth(), 5, 50);
        g2.drawString("Map: "+ mainGame.getLevel().getTopIndex() + " to " + mainGame.getLevel().getBottomIndex(), 5, 60);

        g2.drawString("LevelComplete: " + mainGame.levelComplete(), 5, 75);
        g2.drawString("GameOver?: " + mainGame.gameOver(), 5, 85);
        g2.drawString("LevelsCompleted: " + mainGame.getLevelsCompleted(), 5, 95);
    }


    @Override
    public void paintComponent(final Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        paintMap(g2);
        paintPlayer(g2);
        paintDebug(g2);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

}