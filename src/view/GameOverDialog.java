package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.Controller.MyEndDialogListener;
/**
 * Opens a Dialog where you close the game or start a new game.
 * @date 22.06.2016
 * @author Maximilian Heinze
 *
 */
public class GameOverDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel txtGameOverNeues;
	private JButton newGame = new JButton("Neues Spiel starten");
	private JButton endGame = new JButton("Spiel Beenden");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GameOverDialog dialog = new GameOverDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @date 22.06.2016
	 * Create the dialog.
	 */
	public GameOverDialog() 
	{
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		txtGameOverNeues = new JLabel();
		txtGameOverNeues.setText("Sie haben verloren. Neues Spiel starten?");
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(114)
						.addComponent(txtGameOverNeues, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(125, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addGap(55)
						.addComponent(newGame)
						.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
						.addComponent(endGame)
						.addGap(49))
				);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(23)
						.addComponent(txtGameOverNeues, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(73)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(endGame)
							.addComponent(newGame))
						.addContainerGap(102, Short.MAX_VALUE))
				);
			contentPanel.setLayout(gl_contentPanel);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
			}
			setVisible(true);
	}
	/**
	 * @date 22.06.2016
	 * @param medl
	 */
	public void addListenerOnGameOverDialogButtons(MyEndDialogListener medl)
		{
			endGame.addActionListener(medl);
			newGame.addActionListener(medl);
		}	
}

