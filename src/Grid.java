import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
 
public class Grid extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener
{
   int x, y;
   BufferedImage map;
   Character character;
   int numberOfItems = 2;
   Tree[] trees = new Tree[numberOfItems];
   int[][] grid = new int[3][3];
   String state = "main";
   String[] info = {"age?", "name?"};
   String[] questions = {"age?", "name?"};
   String[][] ans = {{"a", "b", "c"}, {"a", "b", "c"}};
   
   public Grid() {
	   character = new Character(50, 500);
	   trees[0] = new Tree(0, 0);
	   trees[1] = new Tree(2, 2);
	   try 
	   {
          map = ImageIO.read(new File("map.png"));
       } catch(IOException e) {
          e.printStackTrace();
       }
	   for (int i = 0;  i < 3; i++) {
		   for (int j = 0;  j < 3; j++) {
			   grid[i][j] = 0;
		   }
	   }
	   for (int i = 0; i< numberOfItems; i++) {
		   grid[trees[i].getY()][trees[i].getX()] = 1;
	   }
       //sets key listener 
       setFocusable(true);
       addKeyListener(this);
       addMouseMotionListener(this);
   }
   public Dimension getPreferredSize() 
   {
       //Sets the size of the panel
       return new Dimension(1200,800);
   }

   
   public void paintComponent(Graphics g)
   {
      x = 0;
      y = 0;
      
      Color TransRed = new Color(0.5f, 0.5f, 0.5f, 0.7f);

      g.drawImage(map, 0, 0, 1200, 800, null);
      
      for (int i = 0; i < numberOfItems; i++) {
    	  trees[i].drawMe(g);
      }
      character.drawMe(g);
   }

   //implement methods of the KeyListener
   public void keyPressed(KeyEvent e) {
       //key code
       //http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes
	   if (e.getKeyCode()==38) {//Up Arrow 
          character.moveUp();  
      }else if (e.getKeyCode()==40) {//Down Arrow {
           character.moveDown();   
       }else if(e.getKeyCode() == 37) {
          character.moveLeft();   
       }
       else if(e.getKeyCode() == 39) {
          character.moveRight();   
       }
       repaint();
   }
   public void mouseClicked(MouseEvent e) {
       int x = (e.getX() - 100);
       int y = (e.getY() - 100);
       System.out.println(x + " " + y);
       if(state.equals("main")) { 
           
       } else if(state.equals("info")) { 
           
       } else if(state.equals("quiz")) { 
          
       }
   }

   @Override
   public void mousePressed(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseExited(MouseEvent e)
   {
      // TODO Auto-generated method stub
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      // TODO Auto-generated method stub
      
   }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		character.setX(e.getX());
		character.setY(e.getY());
		repaint();
	}

}
