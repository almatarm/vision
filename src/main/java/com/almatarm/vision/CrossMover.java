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
public class CrossMover implements ShapeMover {
    final int SHAPE_WIDTH = 30;
    int state = 0;
    int x, y;
    int width, height;
    boolean isHorizontal = true;
    boolean isForward = false;
    
    public CrossMover(int width, int height) {
        setSize(width, height);
    }
    
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        x = width /2 - SHAPE_WIDTH /2;
        y = height/2 - SHAPE_WIDTH /2;
        state = 0;
    }
    
    private void move() {
        if(isHorizontal) {
            x += isForward ? 10 : -10; 
            if(isForward) {
                isForward = x <= width - SHAPE_WIDTH / 2;    
                if(!isForward) state++;
            } else { // Backward
                isForward = x < 0;
                if(isForward) state++;
            } 
        } else {
            y += isForward ? 10 : -10; 
            if(isForward) {
                isForward = y <= height - SHAPE_WIDTH / 2;    
                if(!isForward) state++;
            } else { // Backward
                isForward = y < 0;
                if(isForward) state++;
            } 
        }
        
        if(state % 3 == 0 && isHorizontal && x > width / 2 - SHAPE_WIDTH /2) {
            x = width /2 - SHAPE_WIDTH /2;
            y = height /2 - SHAPE_WIDTH /2;
            isHorizontal = false;
            isForward = false;
        } else if(state % 3 == 0 && !isHorizontal && y > height / 2 - SHAPE_WIDTH /2) {
            x = width /2 - SHAPE_WIDTH /2;
            y = height /2 - SHAPE_WIDTH /2;
            isHorizontal = true;
            isForward = false;
        }
    }

    @Override
    public void tick(int t) {
        move();
    }
    
    @Override
    public void paint(Graphics2D g2d) {
        g2d.setPaint(Color.red);
        g2d.fillOval(x, y, SHAPE_WIDTH, SHAPE_WIDTH);
    }
}
