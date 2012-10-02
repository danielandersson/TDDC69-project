package se.daniel_andersson.school.tddc69.project;


import java.awt.*;

public class MenuState extends State {

    public MenuState(){
        super("MenuState");
    }

    @Override
    public void render(){
        Graphics2D g = getGraphics2D();
        g.setColor(Color.red);
        g.fillRect(100, 100, 100, 100);
        g.setColor(Color.white);
        g.drawString("This is the menu state", 120, 120);
        super.render();
    }

    @Override
    public void update(){
        super.update();
    }

}
