package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;

import javax.swing.JButton;

import model.Model;
import view.EndDialog;
import view.View;

/**
 * 
 * @author Tim Möschl, René Marton
 * @version 0.1
 */
public class Controller 
{
	/**
	 * @date 09.05.2016
	 * @attribute model Ein Model
	 * @attribute view Ein View
	 * @attribute timer Ein Timer für die Aktionen (z.B. Ballbewegung)
	 */
	private Model model;
	private View view;
	private Timer timer;
	
	/**
	 * @date 09.05.2016
	 * 
	 */
	public Controller()
	{
		model = new Model();
		view = new View(model);		
		timer = new Timer();
		view.addWindowAdapter(new MyWindowAdapter());
		view.setButtonsListener(new MyButtonListener());
	}
	
	/**
	 * @date 09.05.2016, 12.05.2016
	 * 
	 */
	public class MyKeyListener implements KeyListener
	{		
		private boolean vk_right_pressed;
		private boolean vk_left_pressed;
		
		/**
		 * @date 12.05.2016
		 * @param KeyEvent
		 */
		public void keyTyped(KeyEvent ke)
		{
				switch(ke.getKeyCode())
				{
					case KeyEvent.VK_RIGHT:
						vk_right_pressed = true;
//						while(vk_right_pressed)
//						{
							model.moveBat(true, 10);
//						}
						break;
					case KeyEvent.VK_LEFT:
						vk_right_pressed = true;
//						while(vk_right_pressed)
//						{
							model.moveBat(false, 10);
//						}
						break;
				}
		}
		
		/**
		 * @date 12.05.2016
		 * @param KeyEvent
		 */
		public void keyPressed(KeyEvent ke)
		{
			switch(ke.getKeyCode())
			{
				case KeyEvent.VK_RIGHT:
					vk_right_pressed = true;
//					while(vk_right_pressed)
//					{
						model.moveBat(true, 10);
						wait(10);
//					}
					break;
				case KeyEvent.VK_LEFT:
				vk_left_pressed = true;
//				while(vk_left_pressed)
//				{
					model.moveBat(false, 10);
					wait(10);
//				}
					break;
			}
		}
		
		/**
		 * @date 05.06.2016
		 * @param msec
		 */
		private void wait(int msec)
		{
			try
			{
				Thread.sleep(msec);
			}
			catch(InterruptedException e)
			{
				
			}
		}
		
		/**
		 * @date 12.05.2016
		 * @param KeyEvent
		 */
		public void keyReleased(KeyEvent ke)
		{
			switch(ke.getKeyCode())
			{
				case KeyEvent.VK_RIGHT:
					vk_right_pressed = false;
					break;
				case KeyEvent.VK_LEFT:
					vk_left_pressed = false;
					break;					
			}
		}		
	}
	
	
	
	/**
	 * 
	 * @date 12.05.2016, 05.06.2016
	 */
	
	public class MyWindowAdapter extends WindowAdapter
	{
	
	/**
	 * @param WindowEvent
	 */
		public void windowClosing(WindowEvent we)
		{
			new EndDialog();
		}
	}
	
	/**
	 * 
	 * @date 12.05.2016, 05.06.2016
	 */
	public class MyButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			switch(((JButton)ae.getSource()).getText())
			{
				case "Spiel Starten":
					view.changeToGameFrame();
					view.addKeyListener(new MyKeyListener());
					model.start();
					//Start at the beginning, then run every 30 ms.
					timer.schedule(new MyTask(model, view), 0, 50);
					break;
			
				case "Anleitung":
//					view.changeToManualFrame();
					break;
			
				case "Beenden":
					System.exit(0);
					break;

			}
		}
	}
	
	
	
}
