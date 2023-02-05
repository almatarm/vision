/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almatarm.vision;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author almatarm
 */
public class CircularMover implements ShapeMover {
    final int SHAPE_WIDTH = 30;
    int state = 0;
    double x, y;
    int width, height;
    int radius;
    int xCenter, yCenter;
    double speed;
    boolean isHorizontal = true;
    boolean isForward = false;
    
    public CircularMover(int width, int height) {
        setSize(width, height);
    }
    
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        xCenter = width /2 - SHAPE_WIDTH /2;
        yCenter = height/2 - SHAPE_WIDTH /2;
        radius = Math.min(xCenter, yCenter);
        speed = Math.PI / 96;
        state = 0;
    }
    
    private void move(int t) {
        double radian = speed * t;
        x = xCenter + radius * Math.cos(radian);
        y = yCenter + radius * Math.sin(radian);
    }

    @Override
    public void tick(int t) {
        move(t);
    }
    
    @Override
    public void paint(Graphics2D g2d) {
        g2d.setPaint(Color.red);
        g2d.fillOval((int) x, (int) y, SHAPE_WIDTH, SHAPE_WIDTH);
    }
}
