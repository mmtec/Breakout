package model;

public abstract class Component {
	protected int x, y, width, height, diameter;
	
	public Component(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Component(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Component(int x, int y, int diameter) {
		this.x = x;
		this.y = y;
		this.diameter = diameter;
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
	
	public int getDiameter() {
		return diameter;
	}
	
	public abstract String getClassName();
}
