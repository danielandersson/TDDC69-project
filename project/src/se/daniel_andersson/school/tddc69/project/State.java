package se.daniel_andersson.school.tddc69.project;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class State implements Runnable {


    private volatile boolean running = false;

    private long ticks = 0;

    public BufferedImage screen = new BufferedImage(GraphicalViewer.WIDTH, GraphicalViewer.HEIGHT, BufferedImage.TYPE_INT_ARGB);
    private Graphics2D g = screen.createGraphics();

    public String name;

    public State(String s){
        name = s;
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

    public Graphics2D getGraphics(){
        return g;
    }

    public boolean isRunning() {
        return running;
    }

    public long getTicks() {
        return ticks;
    }

    public void render(){}

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
}
