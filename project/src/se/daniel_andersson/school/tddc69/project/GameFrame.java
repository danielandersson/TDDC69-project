package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private JComponent graphicalViewer;
    private Game mainGame;

    public GameFrame(Game mainGame) {
        super("Projectname");
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLayout(new BorderLayout());

        this.mainGame = mainGame;
        graphicalViewer = new GraphicalViewer(mainGame);
        super.add(graphicalViewer, BorderLayout.CENTER);


        super.pack();
    }
}
