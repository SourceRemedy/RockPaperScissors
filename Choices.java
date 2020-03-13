/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author 734260
 */
public abstract class Choices {
    private int x, y;
    private int width, height;
    private Color color;
    private Rectangle bounds;
    private boolean alive = true;
    private Image img;
    private ImageIcon ii;
    
    public Choices(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
//        this.ii = new ImageIcon();
//        this.img = ii.getImage();
        this.bounds = new Rectangle(x, y, width, height);
    }
    
    public abstract void draw(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
    
    public void die() {
        this.alive = false;
    }
    
    public boolean isAlive() {
        return alive;
    }

    public Image getImg() {
        return img;
    }

    public ImageIcon getIi() {
        return ii;
    }
    
    
    
}


