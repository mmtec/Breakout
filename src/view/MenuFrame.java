package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.Controller.MyButtonListener;
import controller.Controller.MyWindowAdapter;
/**
 * Class to create a MenuFrame where you can quit the game, start a new game or read the Manual
 * @author Maximilian Heinze
 */
public class MenuFrame extends JFrame {

	private JPanel contentPane;
	
	private int width = 807;
	private int height = 807;
	private JButton endButton = new JButton("Beenden");
	private JButton startButton = new JButton("Spiel Starten");
	private JButton manualButton = new JButton("Anleitung");


	/**
	 * Create the frame.
	 * @author Maximilian Heinze
	 */
	public MenuFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(width, height);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		startButton.setForeground(Color.WHITE);
		startButton.setBackground(Color.BLACK);
		
		
		manualButton.setForeground(Color.WHITE);
		manualButton.setBackground(Color.BLACK);
		
		
		endButton.setBackground(Color.BLACK);
		endButton.setForeground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(300)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(endButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(manualButton, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(startButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
					.addGap(251))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(253, Short.MAX_VALUE)
					.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(manualButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(endButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(251))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	/**
	 * Method to add a WindowListener to the MenuFrame
	 * @author Maximilian Heinze
	 * @param wa
	 */
	public void addMyWindowListener(MyWindowAdapter wa){
		addWindowListener(wa);
	}
	
	/**
	 * Method to add a Buttonlistener to all Jbuttons in the MEnuFrame
	 * @author Maximilian Heinze
	 * @param mbl
	 */
	public void setButtonsListener(MyButtonListener mbl)
	{
		startButton.addActionListener(mbl);
		endButton.addActionListener(mbl);
		manualButton.addActionListener(mbl);
	}
	
	/**
	 * Method to change from the MenuFrame to the GameFrame
	 * @author Maximilian Heinze
	 * @return new GameFrame returned
	 */
	public GameFrame changeToGameFrame()
    {
		dispose();
		return new GameFrame();
    }

}
