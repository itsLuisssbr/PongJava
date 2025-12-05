package com.pots.utils;

public class Hitbox {
    


    private int x, y, width, height;


    public Hitbox(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Hitbox(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.width = size;
        this.height = size;
    }


    public boolean intersects(Hitbox hb){
        int x2 = hb.getX();
        int y2 = hb.getY();
        int width2 = hb.getWidth();
        int height2 = hb.getHeight();


        


        return false;
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


    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    


    
}
