
package com.pots.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import javax.swing.JFrame;

import com.pots.Entities.Ball;
import com.pots.Entities.Enemy;
import com.pots.Entities.Player;
import com.pots.utils.KeyboardReader;
import com.pots.utils.ObjectHandler;



public class Main extends Canvas implements Runnable{ 

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final int SCALE = 1;

    public static KeyboardReader tecla;

    public BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private boolean isRunning;

    ArrayList<ObjectHandler> objetos = new ArrayList<ObjectHandler>();


    public Main(){
        JFRameInit();

        tecla = new KeyboardReader();
        this.addKeyListener(tecla);

        Player player = new Player(0, 0, 100, 20);
        Enemy enemy = new Enemy(400, 400, 100, 20);
        Ball ball = new Ball(10);

        objetos.add(player);
        objetos.add(enemy);
        objetos.add(ball);
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
        
        for (int i = 0; i < objetos.size(); i++){
            objetos.get(i).tick();
        }

    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = image.getGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        
        for(int i = 0; i < objetos.size(); i++){
            objetos.get(i).render(g, Color.white);
        }
        

        
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, null);
        bs.show();


    }

    @Override
    public void run() {
        requestFocus();
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
