package com.pots.utils;

import java.awt.Color;
import java.awt.Graphics;

public interface ObjectHandler {

    public void tick();

    public void render(Graphics g, Color color);
}
