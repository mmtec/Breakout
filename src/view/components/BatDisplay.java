package view.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class BatDisplay extends JComponent
{
	private int x, y, width, height;
	
	public BatDisplay(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
	}
}
