package view.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class BallDisplay extends JComponent
{
	private int x, y, width, height;
	
	public BallDisplay(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillOval(x, y, width, height);
	}
}
