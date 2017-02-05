import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 
public class Tree
{
    int x;
    int y;
     
    int width;
    int height;
     
    Color green;
    boolean visible;
 
    BufferedImage item;
    
    public Tree(int x, int y)
    {
         
        this.x = x;
        this.y = y;
         
        this.width = 100;
        this.height = 100;
         
        this.green = new Color(103,233,98);
        this.visible = true;
        try {
            item = ImageIO.read(new File("tree.png"));
         } catch(IOException e) {
            e.printStackTrace();
         }
    }
     
 
    public void drawMe(Graphics g)
    {
        if( visible )
        {
        	g.drawImage(item, x*200 + 50, y * 200 + 50, width, height, null);
        }
    }
     
    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }
    public void setX(int x) {
       this.x = x;
    } 
    public void setY(int y)
    {
        this.y = y;
    }
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
    public boolean getVisible()
    {
        return visible;
    }
     
}