package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class State extends JComponent implements Runnable {

    private volatile boolean running = false;

    private long ticks = 0;
    public BufferedImage screen;
    private Graphics2D g;

    public String name;

    private StateChangeListener listener = null;

    public State(String s){
        name = s;
    }

    public StateChangeListener getListener() {
        return listener;
    }
    public void setListener(StateChangeListener listener) {
        this.listener = listener;
    }

    public void start(){
        if(!running){
            running = true;
            new Thread(this).start();
        }
    }

    public void stop(){
        if(running){
            running = !running;
        }
    }

    public Graphics2D getGraphics2D(){
        g = screen.createGraphics();
        return g;
    }

    public boolean isRunning() {
        return running;
    }

    public long getTicks() {
        return ticks;
    }

    public void render(){
        Graphics g = null;
        try {
            g = getGraphics();
            g.setColor(Color.GRAY);
            g.drawImage(screen, 0, 0, screen.getWidth(), screen.getHeight(), this);
        } catch (NullPointerException e) {
            System.out.println("NEJ!");
        }

    }

    public void update(){
        ticks++;
    }

    @Override
    public void run() {
        while(running){
            update();
            render();
        }
    }
    public void updateInputMap() {
    }
}

