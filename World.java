/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.JPanel;
import java.util.Timer;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 *
 * @author 734260
 */
public class World extends JPanel implements MouseListener{
    private ArrayList<Choices> choices = new ArrayList<>();
    private ArrayList<Rock> rocks = new ArrayList<>();   
    private ArrayList<Paper> papers = new ArrayList<>(); 
    private ArrayList<Scissors> scissors = new ArrayList<>();
    ArrayList<Paper> newPapers = new ArrayList<>();
    ArrayList<Rock> newRocks = new ArrayList<>();
    ArrayList<Scissors> newScissors = new ArrayList<>();
    KeyEvent lastPressed;
    Timer timer;
    Random rand = new Random();
    int playerScore = 0;
    int compScore = 0;
    long x = 0;
    
    public World() {
        this.addMouseListener(this);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 720/12);
        super.setSize(800, 600);
    }
    
     public void paintComponent(Graphics g) {
        
         
         super.paintComponent(g);
         
        
         
         g.drawString("Y O U R   S C O R E  :  " + playerScore, 5, 40);
        g.drawString("C O M P U T E R   S C O R E  :  " + compScore, 600, 40);
        g.drawLine (0, 50, 1000, 50);
        
        g.setColor(Color.red);
        
        if (playerScore == 3) {
            g.drawString("Y O U   W I N !", 340, 250);
            g.drawString("P L E A S E   L E A V E   O R   P R E S S   V   T O   P L A Y   A G A I N", 200, 300);
            
        }
        if (compScore == 3) {
            g.drawString("Y O U   L O S E !", 340, 250);
            g.drawString("P L E A S E   L E A V E   O R   P R E S S   V   T O   P L A Y   A G A I N", 200, 300);
            
        }
        
        for (Choices choice : choices) {
            choice.draw(g);
        }      
        x++;
        if (x % 100 == 0) {
            takeOutTheTrash();
        }
        
        
        
        
     }
     
     private void takeOutTheTrash() {
        ArrayList<Choices> trash = new ArrayList<>();
        for (Choices choice : choices) {
            if (!choice.isAlive())
                trash.add(choice);
        }
        choices.removeAll(trash);
        trash.clear();
     }
     
     
     
     private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }
     
     public void keyPressed(KeyEvent event) {
        lastPressed = event;
        
    }
     
     @Override
    public void mouseExited(MouseEvent event) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent event) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent event) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent event) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        System.out.printf("\nMouse Click at (%d, %d)",event.getX(), event.getY());
        switch(lastPressed.getKeyCode()) {
            case KeyEvent.VK_S :
                System.out.println("Scissors.");
                Scissors scissor = new Scissors(event.getX(), event.getY());
                scissors.add(scissor);
                choices.add(scissor);
                int rand_int = rand.nextInt(3);
                if (rand_int == 0) {
                    System.out.println("Computer chose scissors.");
                    Scissors scissor1 = new Scissors(event.getX() + 200, event.getY());
                    scissors.add(scissor1);
                    choices.add(scissor1);
                    System.out.println("It's a draw! Neither team scores.");
                    System.out.println("Your score: " +playerScore);
                    System.out.println("Your score: " +compScore);
                    scissor.die();
                    scissor1.die();
                }
                if (rand_int == 1) {
                    System.out.println("Computer chose paper.");
                    Paper paper1 = new Paper(event.getX() + 200, event.getY());
                    papers.add(paper1);
                    choices.add(paper1);
                    System.out.println("You win!" );
                    playerScore = playerScore + 1;
                    System.out.println("Your score: " +playerScore);
                    System.out.println("Your score: " +compScore);
                    scissor.die();
                    paper1.die();
                }
                if (rand_int == 2) {
                    System.out.println("Computer chose rock.");
                    Rock rock1 = new Rock(event.getX() + 200, event.getY());
                    rocks.add(rock1);
                    choices.add(rock1);
                    System.out.println("You lose!");
                    compScore = compScore + 1;
                    System.out.println("Your score: " +playerScore);
                    System.out.println("Your score: " +compScore);
                    scissor.die();
                    rock1.die();
                }
                break;
            case KeyEvent.VK_P :
                System.out.println("Paper.");
                Paper paper = new Paper(event.getX(), event.getY());
                papers.add(paper);
                choices.add(paper);
                int rand_int1 = rand.nextInt(3);
                if (rand_int1 == 0) {
                    System.out.println("Computer chose paper.");
                    Paper paper2 = new Paper(event.getX() + 200, event.getY());
                    papers.add(paper2);
                    choices.add(paper2);
                    System.out.println("It's a draw! Neither team scores.");
                    System.out.println("Your score: " +playerScore);
                    System.out.println("Your score: " +compScore);
                    paper.die();
                    paper2.die();
                }
                if (rand_int1 == 1) {
                    System.out.println("Computer chose rock.");
                    Rock rock2 = new Rock(event.getX() + 200, event.getY());
                    rocks.add(rock2);
                    choices.add(rock2);
                    System.out.println("You win!" );
                    playerScore = playerScore + 1;
                    System.out.println("Your score: " +playerScore);
                    System.out.println("Your score: " +compScore);
                    rock2.die();
                    paper.die();
                }
                if (rand_int1 == 2) {
                    System.out.println("Computer chose scissors.");
                    Scissors scissor2 = new Scissors(event.getX() + 200, event.getY());
                    scissors.add(scissor2);
                    choices.add(scissor2);
                    System.out.println("You lose!");
                    compScore = compScore + 1;
                    System.out.println("Your score: " +playerScore);
                    System.out.println("Your score: " +compScore);
                    scissor2.die();
                    paper.die();
                }
                break;
            case KeyEvent.VK_R :
                System.out.println("Rock.");
                Rock rock = new Rock(event.getX(), event.getY());
                rocks.add(rock);
                choices.add(rock);
                int rand_int2 = rand.nextInt(3);
                if (rand_int2 == 0) {
                    System.out.println("Computer chose rock.");
                    Rock rock3 = new Rock(event.getX() + 200, event.getY());
                    rocks.add(rock3);
                    choices.add(rock3);
                    System.out.println("It's a draw! Neither team scores.");
                    System.out.println("Your score: " +playerScore);
                    System.out.println("Your score: " +compScore);
                    rock3.die();
                    rock.die();
                }
                if (rand_int2 == 1) {
                    System.out.println("Computer chose scissors.");
                    Scissors scissor3 = new Scissors(event.getX() + 200, event.getY());
                    scissors.add(scissor3);
                    choices.add(scissor3);
                    System.out.println("You win!" );
                    playerScore = playerScore + 1;
                    System.out.println("Your score: " +playerScore);
                    System.out.println("Your score: " +compScore);
                    rock.die();
                    scissor3.die();
                }
                if (rand_int2 == 2) {
                    System.out.println("Computer chose paper.");
                    Paper paper3 = new Paper(event.getX() + 200, event.getY());
                    papers.add(paper3);
                    choices.add(paper3);
                    System.out.println("You lose!");
                    compScore = compScore + 1;
                    System.out.println("Your score: " +playerScore);
                    System.out.println("Your score: " +compScore);
                    rock.die();
                    paper3.die();
                }
                break;
            case KeyEvent.VK_V :
                compScore = 0;
                playerScore = 0;
                x = 0;
                break;
    }
        
      
        
}
}
