package se.daniel_andersson.school.tddc69.project;


import java.awt.*;

public class MenuState extends State {

    public MenuState() {
        super("MenuState");
    }

    @Override
    public void render() {
        Graphics2D g2 = getGraphics();
        g2.setColor(Color.PINK);
        g2.drawString("This is the menu", 120, 120);
    }

    public void update(){
        super.update();
    }
}
