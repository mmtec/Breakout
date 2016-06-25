package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import view.components.BallDisplay;
import view.components.BatDisplay;
import view.components.BrickDisplay;
import controller.Controller.MyEndDialogListener;
import controller.Controller.MyKeyListener;
/**
 * class to create a Gameframe where you play the game.
 * @author Maximilian Heinze
 *
 */
public class GameFrame extends JFrame {
	private int width = 807; // Breite = 1000
	private int height = 807; // Höhe = 1000
	private Graphics g;
	private GameWonDialog gameIsWon;
	private GameOverDialog gameIsLost;
	private boolean isGameOverDialogShown, isGameWonDialogShown;
	
	public GameFrame(){
		setTitle("GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);	// Setzt die Größe des JFrames auf
								// die gewünschten Werte
		getContentPane().setBackground(Color.BLACK); //Setzt den Hintergrund auf Schwarz
		g = getGraphics();
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * Method to draw a Brick 
	 * @author Maximilian Heinze, Julius Knoller
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawBrick(int x, int y, int width, int height)
	{
//		super.paint(g);
//		g.setColor(new Color(255,255,255));
//		g.drawRect(x, y, width, height);
//		//Zeichnet die Bricks. Farbe ist weiß
		getContentPane().add(new BrickDisplay(x, y, width, height));
		revalidate(); //Proved
		repaint();  // Proved
	}
	
	/**
	 * Method to draw the Ball
	 * @author Maximilian Heinze, Julius Knoller
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawBall(int x, int y, int width, int height)
	{
//		super.paint(g);
//		g.setColor(new Color(255,255,255));
//		g.drawOval(x, y, width, height);
//		//Zeichnet den Ball. Farbe ist weiß
		getContentPane().add(new BallDisplay(x, y, width, height));
		revalidate();
		repaint();
	}
	
	/**
	 * method to draw the Bat
	 * @author Maximilian Heinze, Julius Knoller 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawBat(int x, int y, int width, int height)
	{
		getContentPane().add(new BatDisplay(x, y, width, height));
		revalidate();
		repaint();
	}
		
	/**
	 * Method to add a keylistener to the gameframe.
	 * @author Maximilian Heinze
	 * @param keyL
	 */
	public void addMyKeyListener(MyKeyListener keyL)
	{
		addKeyListener(keyL);
	}
	
	/**
	 * Method to remove all drawn objects.
	 * get started when the a new timer is created.
	 *  @author Maximilian Heinze
	 */
	public void emptyContentPane()
	{
		getContentPane().removeAll();
	}
	
	/**
	 * Method to create whether a GameWonDialog or a GameOverDialog
	 * @author Maximilian Heinze
	 * @param gameWon
	 */
	public void showGameFinDialog(boolean gameWon)
	{
		if(gameWon){
			gameIsWon = new GameWonDialog();
			isGameWonDialogShown = true;
		}else{
			gameIsLost = new GameOverDialog();
			isGameOverDialogShown = true;
		}
	}
	
	/**
	 * Method to add the Listener in the GameOverDialog
	 * @author Maximilian Heinze
	 * @param medl
	 */
	public void addListenerOnGameOverDialogButtons(MyEndDialogListener medl)
	{
		gameIsLost.addListenerOnGameOverDialogButtons(medl);
	}
	
	/**
	 * Method to add the Listener in the GameWonDialog
	 * @author Maximilian Heinze
	 * @param medl
	 */
	public void addListenerOnGameWonDialogButtons(MyEndDialogListener medl)
	{
		gameIsWon.addListenerOnGameWonDialogButtons(medl);
	}
	
	/**
	 * Closes any dialogs if opened
	 * @author René Marton, Tim Möschl
	 */
	public void disposeDialog()
	{
		if(isGameOverDialogShown)
		{
			gameIsLost.dispose();
			isGameOverDialogShown = false;
		}
		if(isGameWonDialogShown)
		{
			gameIsWon.dispose();
			isGameWonDialogShown = false;
		}
	}
}
