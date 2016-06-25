package view.components;

import java.awt.Color;
import java.awt.Graphics;

public class BrickDisplay extends Display
{
	private int x, y, width, height;
	
	public BrickDisplay(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
	}
}
