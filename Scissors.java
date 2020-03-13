/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 734260
 */
public class Scissors extends Choices{
    private static final int WIDTH = 100;
    private static final int HEIGHT = 150;
    private static final Color COLOR = new Color(135,206,235);
//    private static final Color COLOR = new Color(220,20,60);
    
    public Scissors(int x, int y) {
        super(x, y, WIDTH, HEIGHT, COLOR);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}
