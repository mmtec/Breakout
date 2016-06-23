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
	 * @author Maximilian Heinze
	 * @return
	 */
	public int getWidth()
	{
		return mf.getWidth();
	}
	/**
	 * @author Maximilian Heinze
	 */
	public int getHeight()
	{
		return mf.getHeight();
	}
	/**
	 * author Maximilian Heinze
	 */
	public void changeToGameFrame()
	{
		gf = mf.changeToGameFrame();
	}
	
	/**
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
	 * @author Maximilian Heinze
	 * @param keyL
	 */
	public void addKeyListener(MyKeyListener keyL)
	{
		gf.addMyKeyListener(keyL);
	}
	/**
	 * @author Maximilian Heinze
	 * @param winA
	 */
	public void addWindowAdapter(MyWindowAdapter winA)
	{
		mf.addMyWindowListener(winA);
	}
	/**
	 * @author Maximilian Heinze	
	 * @param mbl
	 */
	public void setButtonsListener(MyButtonListener mbl)
	{
		mf.setButtonsListener(mbl);
	}
	/**
	 * @author Tim Möschl, René Marton, Maximilian Heinze, Julius Knoller
	 * takes the elements of the array and looks whether it's a ball, a brick, or a bat and draws it.
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
	 * @author Maximilian Heinze
	 * @param medl
	 */
	public GameOverDialog addListenerOnGameOverDialogButtons(MyEndDialogListener medl)
	{
		return gf.addListenerOnGameOverDialogButtons(medl);
	}
	/**
	 * @author Maximilian Heinze
	 * @param medl
	 */
	public GameWonDialog addListenerOnGameWonDialogButtons(MyEndDialogListener medl)
	{
		return gf.addListenerOnGameWonDialogButtons(medl);
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
	
}
