package se.daniel_andersson.school.tddc69.project;

import java.awt.*;


public class GameState extends State {

    public GameState() {
        super("GameState");
    }

    @Override
    public void render() {
        Graphics2D g2 = getGraphics();
        g2.setColor(Color.RED);
        g2.drawString("This is the game", 120, 120);
    }

    public void update(){
        super.update();
    }
}
