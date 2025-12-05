
package com.pots.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;



public class Main extends Canvas implements Runnable{ 

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final int SCALE = 1;

    public BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private boolean isRunning;


    public Main(){
        JFRameInit();
    }

    public void JFRameInit(){
        JFrame frame = new JFrame("Pong");

        frame.setSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        frame.add(this);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        
        
    }

    public static void main(String[] args){
        Main main = new Main();
        main.start();
    }

    public synchronized void start(){
        Thread thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public synchronized void stop(){

    }

    public void tick(){
        
        
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = image.getGraphics();

        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);



        
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, null);
        bs.show();
    }

    @Override
    public void run() {

        while(isRunning){
            tick();
            render();

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
               
                e.printStackTrace();
            }
        }
    }

    

    
}
