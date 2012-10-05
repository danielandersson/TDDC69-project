package se.daniel_andersson.school.tddc69.project;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class State extends Canvas implements Runnable {

    private volatile boolean running = false;

    private long ticks = 0;

    public BufferedImage screen = new BufferedImage(TestStateGame.GAME_WIDTH, TestStateGame.GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private final Graphics2D g = screen.createGraphics();

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

    public Graphics2D getGraphics2D(){
        return g;
    }

    public boolean isRunning() {
        return running;
    }

    public long getTicks() {
        return ticks;
    }

    public void render(){
/*
        BufferStrategy b = getBufferStrategy();
        if(b == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = b.getDrawGraphics();
        g.drawImage(screen, 0, 0, TestStateGame.GAME_WIDTH, TestStateGame.GAME_HEIGHT, this);
        g.dispose();
        b.show();*/
        BufferStrategy bf = this.getBufferStrategy();
        if(bf == null){
            createBufferStrategy(1);
            return;
        }
        Graphics g = null;

        try {
            g = bf.getDrawGraphics();


            // It is assumed that mySprite is created somewhere else.
            // This is just an example for passing off the Graphics object.
            g.drawImage(screen, 0, 0, TestStateGame.GAME_WIDTH, TestStateGame.GAME_HEIGHT, this);

        } finally {
            // It is best to dispose() a Graphics object when done with it.
            g.dispose();
        }

        // Shows the contents of the backbuffer on the screen.
        bf.show();
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

}

