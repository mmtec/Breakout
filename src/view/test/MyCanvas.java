package view.test;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent 
{
	  public void paint(Graphics g) 
	  {
	    g.drawRect (10, 10, 200, 200);  
	  }
}
