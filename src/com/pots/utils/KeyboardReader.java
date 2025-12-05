package com.pots.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardReader implements KeyListener{

    // 1 para esquera, 2 para direita

    
    public static final int LEFT = 1;
    public static final int RIGHT = 2;

    private int getDirection = 0;
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_A){
            getDirection = LEFT;
            //System.out.println("Esquerda");
        }

        else if(e.getKeyCode() == KeyEvent.VK_D){
            getDirection = RIGHT;
            //System.out.println("Direita");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        getDirection = 0;
    }

    public int getDirection(){
        return getDirection;
    }

}
