package view;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

/**
 * Class where you can read the Manual
 * @date 23.06.2016
 * @author Maximilian Heinze
 *
 */
public class ManualFrame extends JFrame {

	private JPanel contentPane;
	private int width = 807;
	private int height = 807;
	
	/**
	 * Create the frame.
	 * @date 23.06.2016
	 * @author Maximilian Heinze
	 */
	public ManualFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width,height);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBreak = new JLabel("Breakout Kurzanleitung");
		lblBreak.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JLabel lblZielDesSpiels = new JLabel("Ziel des Spiels ist, mit dem Ball alle Bricks - die oberen Bl\u00F6cke - zu zerst\u00F6ren.");
		lblZielDesSpiels.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Um den Schl\u00E4ger zu bewegen benuten sie die linke und rechte Pfeiltaste");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblBreak, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
							.addGap(190))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblZielDesSpiels, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE))
							.addGap(69))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBreak, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblZielDesSpiels, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(414, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
