package view;

import javax.swing.JPanel;

import view.components.BallDisplay;
import view.components.BatDisplay;
import view.components.BrickDisplay;

public class GamePanel extends JPanel {

	public GamePanel() {
		setVisible(true);
		setDoubleBuffered(true);
	}
	
	public void drawBall(int x, int y, int width, int height) {
		add(new BallDisplay(x, y, width, height));
		revalidate();
		repaint();
	}
	
	public void drawBrick(int x, int y, int width, int height) {
		add(new BrickDisplay(x, y, width, height));
		revalidate();
		repaint();
	}
	
	public void drawBat(int x, int y, int width, int height) {
		add(new BatDisplay(x, y, width, height));
		revalidate();
		repaint();
	}
	
}
