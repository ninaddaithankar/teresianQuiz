package frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import control.Controller;
import frames.QuestionFrame;

public class StandardSelectionScreen
{

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void showStandardSelectionScreen() 
	{
		JPanel standardSelectionScreen=Controller.standardSelectionScreen;
		
		standardSelectionScreen.setBackground(Color.BLACK);
		standardSelectionScreen.setBorder(new EmptyBorder(5, 5, 5, 5));
		standardSelectionScreen.setLayout(null);
		
		JTextPane txtpnSelectAStandard = new JTextPane();
		txtpnSelectAStandard.setForeground(Color.YELLOW);
		txtpnSelectAStandard.setBackground(Color.BLACK);
		txtpnSelectAStandard.setBounds(520, 294 , 900 , 73);
		txtpnSelectAStandard.setFont(new Font("Segoe UI", Font.BOLD, 50));
		txtpnSelectAStandard.setEditable(false);
		txtpnSelectAStandard.setText("Select a standard to ask questions for:");
		standardSelectionScreen.add(txtpnSelectAStandard);
		
		Panel panel = new Panel();
		panel.setBounds(196, 534, 1522, 382);
		standardSelectionScreen.add(panel);
		
		JButton btn_6thstd = new JButton("6th Std");
		btn_6thstd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Controller.standard=6;
				Controller.click=0;
				QuestionFrame frame = new QuestionFrame();
				frame.setVisible(true);
				Controller.qframe=frame;
			}
		});
		btn_6thstd.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 40));
		btn_6thstd.setPreferredSize(new Dimension(300, 150));
		
		JButton btn_7thstd = new JButton("7th Std");
		btn_7thstd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Controller.standard=7;
				Controller.click=0;
				QuestionFrame frame = new QuestionFrame();
				frame.setVisible(true);
				Controller.qframe=frame;
			}
		});
		btn_7thstd.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 40));
		btn_7thstd.setPreferredSize(new Dimension(300, 150));
		
		JButton btn_8thstd = new JButton("8th Std");
		btn_8thstd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Controller.standard=8;
				Controller.click=0;
				QuestionFrame frame = new QuestionFrame();
				frame.setVisible(true);
				Controller.qframe=frame;
			}
		});
		btn_8thstd.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 40));
		btn_8thstd.setPreferredSize(new Dimension(300, 150));
		
		JButton btn_9thstd = new JButton("9th Std");
		btn_9thstd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Controller.standard=9;
				Controller.click=0;
				QuestionFrame frame = new QuestionFrame();
				frame.setVisible(true);
				Controller.qframe=frame;
			}
		});
		btn_9thstd.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 40));
		btn_9thstd.setPreferredSize(new Dimension(300, 150));
		
		JButton btn_10thstd = new JButton("10th Std");
		btn_10thstd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Controller.standard=10;
				Controller.click=0;
				QuestionFrame frame = new QuestionFrame();
				frame.setVisible(true);
				Controller.qframe=frame;
			}
		});
		btn_10thstd.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 40));
		btn_10thstd.setPreferredSize(new Dimension(300, 150));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(279)
							.addComponent(btn_6thstd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(btn_7thstd, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(btn_8thstd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(445)
							.addComponent(btn_9thstd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(btn_10thstd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(274, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_6thstd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_7thstd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_8thstd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_9thstd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_10thstd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(640, 100, 634, 99);
		standardSelectionScreen.add(panel_1);
		
		JTextPane txtpnRound = new JTextPane();
		txtpnRound.setBackground(Color.BLACK);
		txtpnRound.setForeground(Color.YELLOW);
		txtpnRound.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 75));
		txtpnRound.setText(" Round 1 ");
		panel_1.add(txtpnRound);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(583, 247, 748, 2);
		standardSelectionScreen.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(583, 422, 748, 2);
		standardSelectionScreen.add(separator_1);
		
		JButton btnBackToRound = new JButton("<-- Back");
		btnBackToRound.setForeground(Color.DARK_GRAY);
		btnBackToRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JPanel cards=Controller.cards;
				CardLayout cardLayout=(CardLayout)cards.getLayout();
				cardLayout.show(cards, "RoundSelectionScreen");
			}
		});
		btnBackToRound.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnBackToRound.setBounds(78, 100, 164, 70);
		standardSelectionScreen.add(btnBackToRound);
	}
}
