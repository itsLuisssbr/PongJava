package com.pots.Entities;

import java.awt.Graphics;

import java.util.Random;

import com.pots.utils.Hitbox;

public class Ball {

    private int x, y, size;

    private Hitbox hb;

    private double speed;
    
    
    public Ball(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
        hb = new Hitbox(x, y, size);
        
    }

    public Ball(int size){
        x = 0;
        y = 0;
        this.size = size;
    }


    public void tick(){

    }

    public void render(Graphics g){
        Random rand = new Random();

        int angulo = rand.nextInt(90);
        double anguloRad = Math.toRadians((double) angulo);
        double sin = Math.sin(anguloRad);
        double cos = Math.cos(anguloRad);

        x+=speed*sin;
        y+=speed*cos;

    

        


    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    
    
}
