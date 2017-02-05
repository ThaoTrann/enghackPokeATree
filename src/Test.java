import javax.swing.*;

import java.awt.MouseInfo;
import java.awt.event.*;

public class Test extends JFrame implements MouseListener, MouseMotionListener
{

	public JLabel label;

	public static void main(String args[]) 
	{
		new Test();
	}

	Test() 
	{
		setSize(500, 400);
		setTitle("Java Swing - JFrame  Detect Mouse Events");

		label = new JLabel("No Mouse Event Captured", JLabel.CENTER);
		add(label);
		addMouseMotionListener(this);
		addMouseListener(this);
		setVisible(true);
	}


	//Overridden Methods from MouseListener Interface
	//These methods are called automatically when corresponding mouse
	//event occurs 
	/////////////////////////////////////////////////
	public void mousePressed(MouseEvent e) 
	{
	   label.setText("Mouse Pressed");
	}
	
	public void mouseReleased(MouseEvent e)
	{
	    label.setText("Mouse Released" + e.getX() + " " + e.getY());
	}
	
	public void mouseEntered(MouseEvent e) 
	{
	    label.setText("Mouse Entered" + e.getX() + " " + e.getY());
	}
	
	public void mouseExited(MouseEvent e) 
	{
	    label.setText("Mouse Exited");
	}
	
	public void mouseClicked(MouseEvent e) 
	{
	    label.setText("Mouse Clicked");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		label.setText("Mouse Moved" + e.getX() + " " + e.getY());
	}
}