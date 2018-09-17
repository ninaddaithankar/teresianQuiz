package frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import control.Controller;
import frames.SpectrumRoundFrame;

public class RoundSelectionScreen
{
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void showRoundSelectionScreen()
	{
		JPanel roundSelectionScreen=Controller.roundSelectionScreen;
		roundSelectionScreen.setForeground(Color.LIGHT_GRAY);
		roundSelectionScreen.setBackground(Color.BLACK);
		roundSelectionScreen.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JTextPane txtpnSelectTheRound = new JTextPane();
		txtpnSelectTheRound.setFont(new Font("Segoe UI", Font.BOLD, 55));
		txtpnSelectTheRound.setForeground(Color.green);
		txtpnSelectTheRound.setBackground(Color.BLACK);
		txtpnSelectTheRound.setEnabled(true);
		txtpnSelectTheRound.setEditable(false);
		txtpnSelectTheRound.setText("Select the Round");
		
		JButton btnRound1 = new JButton("TAKE YOUR PICK");
		btnRound1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JPanel cards=Controller.cards;
				CardLayout cardLayout=(CardLayout)cards.getLayout();
				cardLayout.show(cards,"StandardSelectionScreen");
			}
		});
		btnRound1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 60));
		
		JButton btnRound2 = new JButton("SPECTRUM");
		btnRound2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 60));
		btnRound2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				SpectrumRoundFrame sproundframe=new SpectrumRoundFrame();
				Controller.spectrumRound=sproundframe;
				sproundframe.setVisible(true);
			}
		});
		
		JButton btnRound3 = new JButton("LIVE WIRE");
		btnRound3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 60));
		btnRound3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				AudioSelection as=new AudioSelection();
				Controller.audioSelection=as;
				as.setVisible(true);
			}
		});
		
		JButton btnRound4 = new JButton("ALL OR NOTHING");
		btnRound4.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 60));
		btnRound4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				RapidFireTeamSelection rapidFireFrame=new RapidFireTeamSelection();
				Controller.rapidFireTeamSelection=rapidFireFrame;
				rapidFireFrame.setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_contentPane = new GroupLayout(roundSelectionScreen);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(235, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnRound3, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnRound1, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE))
								.addGap(139)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnRound2, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnRound4, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE))
								.addGap(224))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(txtpnSelectTheRound, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(733)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1006, GroupLayout.PREFERRED_SIZE)
							.addGap(444))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(79)
					.addComponent(txtpnSelectTheRound, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRound1, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRound2, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addGap(117)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRound3, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRound4, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		roundSelectionScreen.setLayout(gl_contentPane);
		
		JButton next=new JButton("Next");
		roundSelectionScreen.add(next);
		
	}

}
