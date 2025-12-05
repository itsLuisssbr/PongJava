package com.pots.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

    private int x, y, width, height;

    private Rectangle hitbox;

    public Entity(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void tick(){
        
    }

    public void render(Graphics g, int color){
        g.setColor(new Color(color));
        g.fillRect(x, y, width, height);
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

}
