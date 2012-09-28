package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {

    private JComponent graphicalViewer;
    private Game mainGame;

    public GameFrame(final Game mainGame) {
        super("Projectname");
        super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        this.mainGame = mainGame;
        graphicalViewer = new GraphicalViewer(mainGame);
        super.add(graphicalViewer, BorderLayout.CENTER);

        final Action moveUp = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UP");
                mainGame.getPlayer().moveUp();
            }
        };
        final Action moveLeft = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("LEFT");
                mainGame.getPlayer().moveLeft();
            }
        };
        final Action moveRight = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("RIGHT");
                mainGame.getPlayer().moveRight();
            }
        };
        final Action moveDown = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("DOWN");
                mainGame.getPlayer().moveDown();
            }
        };

        graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("UP"), "moveUp");
        graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        graphicalViewer.getActionMap().put("moveUp", moveUp);
        graphicalViewer.getActionMap().put("moveLeft", moveLeft);
        graphicalViewer.getActionMap().put("moveRight", moveRight);
        graphicalViewer.getActionMap().put("moveDown", moveDown);

        super.pack();
    }

    public void rePaint() {
        graphicalViewer.repaint();
    }
}
