package com.almatarm.vision;

import java.awt.Graphics2D;

/**
 *
 * @author almatarm
 */
public interface ShapeMover {
    void tick(int t);
    void paint(Graphics2D g2d);
}
