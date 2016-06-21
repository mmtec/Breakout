package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MyJDialog extends JDialog {
		
	JButton newGame = new JButton("Neues Spiel");
	JButton exitGame = new JButton("Spiel beenden");
	public MyJDialog(){
		JLabel gameOver = new JLabel("GAME OVER. Neues Spiel starten?");
		gameOver.setHorizontalAlignment(JLabel.CENTER);
		setTitle("Game Over");
		setSize(450, 200);
		setModal(true);
		setLayout(new BorderLayout());
		add(gameOver, BorderLayout.NORTH);
		add(newGame, BorderLayout.WEST);
		add(exitGame, BorderLayout.EAST);
		setVisible(true);
	}
	public void addActionListener(ActionListener listener){
		newGame.addActionListener(listener);
		exitGame.addActionListener(listener);
	}
}
