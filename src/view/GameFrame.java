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
public class GameFrame {
	private JFrame frame;
	private int width = 807;
	private int height = 807;
	private Graphics g;
	private GameWonDialog gameIsWon;
	private GameOverDialog gameIsLost;
	private GamePanel gp;
	private boolean isGameOverDialogShown, isGameWonDialogShown;
	
	public GameFrame(){
		frame = new JFrame();
		gp = new GamePanel();
		frame.setContentPane(gp);
		frame.setTitle("GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		gp.setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setVisible(true);
		
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
		gp.drawBrick(x, y, width, height);
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
		gp.drawBall(x, y, width, height);
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
		gp.drawBat(x, y, width, height);

	}
		
	/**
	 * Method to add a keylistener to the gameframe.
	 * @author Maximilian Heinze
	 * @param keyL
	 */
	public void addMyKeyListener(MyKeyListener keyL)
	{
		frame.addKeyListener(keyL);
	}
	
	/**
	 * Method to remove all drawn objects.
	 * get started when the a new timer is created.
	 *  @author Maximilian Heinze
	 */
//	public void emptyContentPane()
//	{
//		frame.getContentPane().removeAll();
//	}
	
	/**
	 * Method to create either a GameWonDialog or a GameOverDialog
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
