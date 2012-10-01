package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;

public class GraphicalViewer extends JComponent {
    public static int WIDTH;// = 300;
    public static int HEIGHT;// = 600;

    private static Game mainGame;



    public GraphicalViewer(Game mainGame) {
        this.mainGame = mainGame;
        HEIGHT = mainGame.getLevel().screenHeight * mainGame.getLevel().getTileHeight();
        WIDTH = mainGame.getLevel().getLevelWidth() * mainGame.getLevel().getTileWidth();
    }


    private void paintPlayer(final Graphics2D g2) {
        g2.setColor(Color.PINK);
        int XMath = mainGame.getPlayer().getXCoord();
        int YMath = HEIGHT - (mainGame.getPlayer().getYCoord()+1);
        g2.fill(new Rectangle2D.Double(XMath, YMath, mainGame.getLevel().getTileWidth(), mainGame.getLevel().getTileHeight()));
    }

    private void paintMap(final Graphics2D g2) {
        for (int i = mainGame.getLevel().getTopIndex(); i <= mainGame.getLevel().getBottomIndex(); i++) {
            for (int j = 0; j < mainGame.getLevel().getLevelWidth(); j++) {
                int XMath = mainGame.getLevel().getTileWidth()*j;
                int YMath = mainGame.getLevel().getTileHeight()*(i-mainGame.getLevel().getTopIndex())+mainGame.getLevel().innerTile;
                if (mainGame.getLevel().getMap()[i][j] != null) {
                    g2.setColor(mainGame.getLevel().getMap()[i][j].paintColor());
                    g2.fill(new Rectangle2D.Double(XMath, YMath, mainGame.getLevel().getTileWidth(), mainGame.getLevel().getTileHeight()));
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

        g2.drawString("MapSize: H:" + mainGame.getLevel().getLevelHeight() + " W:" + mainGame.getLevel().getLevelWidth(), 5, 40);
        g2.drawString("Map: "+ mainGame.getLevel().getTopIndex() + " to " + mainGame.getLevel().getBottomIndex(), 5, 50);

        g2.drawString("LevelComplete: " + mainGame.levelComplete(), 5, 65);
        g2.drawString("GameOver?: " + mainGame.gameOver(), 5, 75);
        g2.drawString("LevelsCompleted: " + mainGame.getLevelsCompleted(), 5, 85);
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
