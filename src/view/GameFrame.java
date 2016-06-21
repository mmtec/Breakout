package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import controller.Controller.MyKeyListener;
import view.components.BallDisplay;
import view.components.BatDisplay;
import view.components.BrickDisplay;

public class GameFrame extends JFrame {
	private int width = 800; // Breite = 800
	private int height = 800; // Höhe = 800
	private Graphics g;
	
	public GameFrame(){
		setTitle("GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);	// Setzt die Größe des JFrames auf
								// die gewünschten Werte
		getContentPane().setBackground(Color.BLACK); //Setzt den Hintergrund auf Schwarz
		g = getGraphics();
		setVisible(true);
	}

	public void drawBrick(int x, int y, int width, int height){
//		super.paint(g);
//		g.setColor(new Color(255,255,255));
//		g.drawRect(x, y, width, height);
//		//Zeichnet die Bricks. Farbe ist weiß
		getContentPane().add(new BrickDisplay(x, y, width, height));
		revalidate(); //Proved
		repaint();  // Proved
		}
	
	public void drawBall(int x, int y, int width, int height){
//		super.paint(g);
//		g.setColor(new Color(255,255,255));
//		g.drawOval(x, y, width, height);
//		//Zeichnet den Ball. Farbe ist weiß
		getContentPane().add(new BallDisplay(x, y, width, height));
		revalidate();
		repaint();
		}
	
	public void drawBat(int x, int y, int width, int height){
//		super.paint(g);
//		g.setColor(new Color(255,255,255));
//		g.drawRect(x, y, width, height);
//		//Zeichnet den Schläger. Farbe ist weiß
		getContentPane().add(new BatDisplay(x, y, width, height));
		revalidate();
		repaint();
		}
	
	public void gameOver(){
		GameOverDialog gameOverDialog = new GameOverDialog();
	}
	
	public void drawBrickBlack(int x, int y, int width, int height){
//		super.paint(g);
//		g.setColor(new Color(0,0,0));
//		g.drawRect(x, y, width, height);
//		//Lässt den Brick "verschwinden". Farbe ist schwarz
		//FIXME STUB
		
	}
	
	public void drawBallBlack(int x, int y, int width, int height){
//		super.paint(g);
//		g.setColor(new Color(0,0,0));
//		g.drawOval(x, y, width, height);
//		//Lässt den Ball "verschwinden". Farbe ist schwarz.
		//FIXME STUB
		}
	
	public void addMyKeyListener(MyKeyListener keyL){
		addKeyListener(keyL);
	}
	
	public void emptyContentPane()
	{
		getContentPane().removeAll();
	}
	
}
