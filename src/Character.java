import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Character
{
   BufferedImage character;
   int x, y;
   int r = (int) (Math.random()*4);
   static final int VELOCITY = 10;
   int radius;
   Color blue;
   boolean visible = true;
   
   public Character(int x, int y)
   {
       this.x = x;
       this.y = y;
       
       this.radius = 20;
   }
    

   public void drawMe(Graphics g)
   {
	   g.setColor(Color.blue);
	   g.fillOval(x, y, radius, radius);
	   g.drawOval(x-radius, y-radius, radius*3, radius*3);
   }
   public void moveUp()
   {
       y = y - VELOCITY;
   }
    
   public void moveDown()
   {
       y = y + VELOCITY;
   }
   public void moveLeft()
   {
       x = x - VELOCITY;
       if(x < 0)
          x = 0;
   }
    
   public void moveRight()
   {
       x = x + VELOCITY;
       if(x > 790)
          x = 790;
   }
  
   public void checkColision(Tree p) {
      if (visible == true && p.getVisible() == true) {
         int pX = p.getX();
         int pY = p.getY();
         int pWidth = p.getWidth();
         int pHeight = p.getHeight();
         
         if (pX + pWidth >= x && pX <= radius + x 
               && pY + pHeight >= y && pY <= y+ radius) {
            visible = false;
            p.setVisible(false);
         }
      }
   }
   public void playSoundE()
   {
      try
      {
         File rsound = new File("laser.wav");
         AudioInputStream sound = AudioSystem.getAudioInputStream(rsound);
         DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
         Clip clip = (Clip) AudioSystem.getLine(info);
         clip.open(sound);
         clip.start();
      }
      catch (Exception exc)
      {
          exc.printStackTrace(System.out);
      }
   }
   
   public int getX()
   {
       return x;
   }
    
   public int getY()
   {
       return y;
   }
   public void setX(int x)
   {
       this.x = x;
   }
    
   public void setY(int y)
   {
       this.y = y;
   }

   public boolean getVisible() {
      return visible;
   }
}
