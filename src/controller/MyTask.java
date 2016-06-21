package controller;

import java.util.TimerTask;

import model.Model;
import view.View;

public class MyTask extends TimerTask
{
	private int[] touchesBrickArray;
	private Model model;
	private View view;
	
	public MyTask(Model model, View view)
	{
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void run()
	{
		touchesBrickArray = model.touchesBrick();
		
		//Returns the ball's coordinates
		model.refreshBallPosition();
				
		//When falling into the void
		if(model.touchesVoid())
		{
//			model.destroyBall();
//			view.destroyBall();
			view.gameOver();
		}
		else if(model.touchesWall() != -1) //When the ball hits the wall
		{
			switch(model.touchesWall())
			{
				//1: Ball touches left or right
				case 1:
					model.reverseXSpeed(); // x => -x
					break;
					
				//2. Ball touches upper Wall
				case 2:
					model.reverseYSpeed(); // y => -y
					break;
			}
		}
		
		if(model.touchesBat()) //Ball touches the bat
		{
			model.reverseYSpeed(); //y => -y
		}
		
		if(touchesBrickArray[0] != -1)
		{
			int[] coordinatesArray = {touchesBrickArray[0], touchesBrickArray[1]};
			model.destroyBrick(coordinatesArray);
									
			switch(touchesBrickArray[2])
			{
				case 1: //Touches the left or right side of the brick
					model.reverseXSpeed();
					break;
				case 2: //Touches the top or bottom side of the brick
					model.reverseYSpeed();
					break;
			}
		}
		model.refresh();
		view.drawListElements();
	}
}

