package com.pots.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.pots.utils.ObjectHandler;


public abstract class Entity implements ObjectHandler{

    private int x, y, width, height;

    private Rectangle hitbox;

    public Entity(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Entity(){
        this.x = 0;
        this.y = 0;
        this.width = 100;
        this.height = 30;
    }

    public void tick(){
        
    }

    public void render(Graphics g, Color color){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

}
