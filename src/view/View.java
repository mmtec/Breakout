package view;

import java.util.ArrayList;

import model.Ball;
import model.Bat;
import model.Brick;
import model.Component;
import model.Model;
import controller.Controller.MyButtonListener;
import controller.Controller.MyKeyListener;
import controller.Controller.MyWindowAdapter;

public class View {
	
	private MenuFrame mf;
	private GameFrame gf;
//	private ManualFrame manf;
	private Model model;
	
	public View(Model model){
		this.model = model;
		mf = new MenuFrame();
	}
	
	public int getWidth()
	{
		return mf.getWidth();
	}
	
	public int getHeight()
	{
		return mf.getHeight();
	}
	
	public void changeToGameFrame()
	{
		gf = mf.changeToGameFrame();
	}
	
//	public void changeToManualFrame()
//	{
//		manf = mf.changeToManualFrame();
//	}
	
	public void drawBat(int x, int y, int width, int height)
	{
		gf.drawBat(x, y, width, height);
	}
	
	public void drawBrick(int x, int y, int width, int height)
	{
		gf.drawBrick(x, y, width, height);
	}
	
	public void drawBall(int x, int y, int width, int height)
	{
		gf.drawBall(x, y, width, height);
	}
	
	public void drawBallBlack(int x, int y, int width, int height)
	{
		gf.drawBallBlack(x, y, width, height);
	}
	
	public void drawBrickBlack(int x, int y, int width, int height)
	{
		gf.drawBrickBlack(x, y, width, height);
	}
	
	public void addKeyListener(MyKeyListener keyL)
	{
		gf.addMyKeyListener(keyL);
	}
	
	public void addWindowAdapter(MyWindowAdapter winA)
	{
		mf.addMyWindowListener(winA);
	}
	
	public void gameOver()
	{
		gf.gameOver();
	}
	
	public void setButtonsListener(MyButtonListener mbl)
	{
		mf.setButtonsListener(mbl);
	}
	
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
}
