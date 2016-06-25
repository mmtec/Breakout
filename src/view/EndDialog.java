package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * Opens the Dialog when you want to close the Game in the Menuframe.
 * @author Maximilian Heinze
 */
public class EndDialog extends JDialog 
{
	
	private final JPanel contentPanel = new JPanel();
	private JLabel txtWollenSieDas;
	private JLabel txtDasSpielWird;
	JButton cancelButton = new JButton("Cancel");
	JButton okButton = new JButton("OK");

	/**
	 * Create the dialog.
	 * @author Maximilian Heinze
	 */
	public EndDialog() 
	{
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		{
			txtDasSpielWird = new JLabel();
			txtDasSpielWird.setText("Das Spiel wird beendet. Wirklich beenden?");
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(109)
					.addComponent(txtDasSpielWird, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(75)
					.addComponent(txtDasSpielWird, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
			}
			{
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}
	
	/**
	 * Method to add a Buttonlistener to the JButtons of the EndDialog.
	 * @author Maximilian Heinze
	 * @param listener
	 */
	public void addActionListener(ActionListener listener)
	{
		okButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
	}

}
