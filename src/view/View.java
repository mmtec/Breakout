package view;

import java.util.ArrayList;

import model.Ball;
import model.Bat;
import model.Brick;
import model.Component;
import model.Model;
import controller.Controller.MyButtonListener;
import controller.Controller.MyEndDialogListener;
import controller.Controller.MyKeyListener;
import controller.Controller.MyWindowAdapter;
/**
 * class to draw all frames and dialogs
 * @author Maximilian Heinze
 * 
 */
public class View {
	
	private MenuFrame mf;
	private GameFrame gf;
	private ManualFrame manf;
	private Model model;
		
	public View(Model model){
		this.model = model;
		mf = new MenuFrame();
	}
	
	/**
	 * Method to return the width of the MenuFrame
	 * @author Maximilian Heinze
	 * @return
	 */
	public int getWidth()
	{
		return mf.getWidth();
	}
	
	/**
	 * Method to return the height of the MenuFrame
	 * @author Maximilian Heinze
	 * @return
	 */
	public int getHeight()
	{
		return mf.getHeight();
	}
	
	/**
	 * Method to change from MenuFrame to GameFrame
	 * @author Maximilian Heinze
	 */
	public void changeToGameFrame()
	{
		gf = mf.changeToGameFrame();
	}
	
	/**
	 * Method to draw the Bat
	 * @author Maximilian Heinze
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawBat(int x, int y, int width, int height)
	{
		gf.drawBat(x, y, width, height);
	}
	
	/**
	 * Method to draw the Bricks
	 * @author Maximilian Heinze
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawBrick(int x, int y, int width, int height)
	{
		gf.drawBrick(x, y, width, height);
	}
	
	/**
	 * Method to draw the Ball
	 * @author Maximilian Heinze
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawBall(int x, int y, int width, int height)
	{
		gf.drawBall(x, y, width, height);
	}
	
	/**
	 * Method to add a KeyListener to the GameFrame
	 * @author Maximilian Heinze
	 * @param keyL
	 */
	public void addKeyListener(MyKeyListener keyL)
	{
		gf.addMyKeyListener(keyL);
	}
	
	/**
	 * Method to add a WindowListener to the MenuFrame
	 * @author Maximilian Heinze
	 * @param winA
	 */
	public void addWindowAdapter(MyWindowAdapter winA)
	{
		mf.addMyWindowListener(winA);
	}
	
	/**
	 * Method to add a ButtonListener on all JButtons on the MenuFrame
	 * @author Maximilian Heinze	
	 * @param mbl
	 */
	public void setButtonsListener(MyButtonListener mbl)
	{
		mf.setButtonsListener(mbl);
	}
	
	/**
	 * Method to take the elements of the array and looks whether it's a ball, a brick, or a bat and draws it
	 * @author Tim Möschl, René Marton, Maximilian Heinze, Julius Knoller
	 * 
	 */
	public void drawListElements()
	{
		gf.emptyContentPane();
		ArrayList<Component> list = model.returnList();
		for(int i = 0; i < list.size(); i++)
		{
			switch(list.get(i).getClassName())
			{
			case "ball": 
				Ball ball = (Ball)list.get(i);	//Casten: Objekt das wir bekommen kann alles sein also müssen wir Java sagen was es ist.
				drawBall(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
				break;
			case "bat":
				Bat bat = (Bat)list.get(i);
				drawBat(bat.getX(), bat.getY(), bat.getWidth(), bat.getHeight());
				break;
			case "brick":
				Brick brick = (Brick)list.get(i);
				drawBrick(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
				break;
			}
		}
	}
	
	/**
	 * Method to add an EndDialogListener to the GameFrame
	 * @author Maximilian Heinze
	 * @param medl
	 */
	public void addListenerOnGameOverDialogButtons(MyEndDialogListener medl)
	{
		gf.addListenerOnGameOverDialogButtons(medl);
	}
	
	/**
	 * Method to add an EndDialoglistener to the GameFrame
	 * @author Maximilian Heinze
	 * @param medl
	 */
	public void addListenerOnGameWonDialogButtons(MyEndDialogListener medl)
	{
		gf.addListenerOnGameWonDialogButtons(medl);
	}
	
	/**
	 * Method to open a JDialog which says whether you have won or not
	 * @author Maximilian Heinze
	 * @param gameWon
	 */
	public void showGameFinDialog(boolean gameWon)
	{
		gf.showGameFinDialog(gameWon);
	}
	
	public void disposeDialog()
	{
		gf.disposeDialog();
	}
	
}
