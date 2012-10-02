package se.daniel_andersson.school.tddc69.project;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class State extends Canvas implements Runnable {

    private volatile boolean running = false;

    private long ticks = 0;

    public BufferedImage screen = new BufferedImage(TestStateGame.GAME_WIDTH, TestStateGame.GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
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

        BufferStrategy b = getBufferStrategy();
        if(b == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = b.getDrawGraphics();
        g.drawImage(screen, 0, 0, TestStateGame.GAME_WIDTH, TestStateGame.GAME_HEIGHT, this);
        g.dispose();
        b.show();
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

