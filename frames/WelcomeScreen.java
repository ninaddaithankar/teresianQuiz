package frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import control.Controller;

public class WelcomeScreen
{
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void showWelcomeScreen() 
	{
		JPanel welcomeScreen=Controller.welcomeScreen;
		welcomeScreen.setBackground(Color.BLACK);
		welcomeScreen.setBorder(new EmptyBorder(5, 5, 5, 5));
		welcomeScreen.setLayout(null);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(5, 5, 0, 523);
		welcomeScreen.add(separator);
		
		Panel panel = new Panel();
		panel.setBounds(412, 325, 1088, 233);
		welcomeScreen.add(panel);
		
		JTextPane txtpnWelcomeToTime = new JTextPane();
		txtpnWelcomeToTime.setForeground(Color.LIGHT_GRAY);
		txtpnWelcomeToTime.setBackground(Color.DARK_GRAY);
		txtpnWelcomeToTime.setEditable(false);
		txtpnWelcomeToTime.setFont(new Font("Segoe UI", Font.BOLD, 99));
		txtpnWelcomeToTime.setText("Welcome To TIME Quiz");
		panel.add(txtpnWelcomeToTime);
		
		JButton btnContinue = new JButton("Ready? Click Me!");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JPanel cards=Controller.cards;
				CardLayout cardLayout=(CardLayout)cards.getLayout();
				cardLayout.next(cards);
				RoundSelectionScreen.showRoundSelectionScreen();
			}
		});
		btnContinue.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		btnContinue.setForeground(Color.DARK_GRAY);
		btnContinue.setBackground(Color.CYAN);
		btnContinue.setBounds(820, 712, 273, 79);
		welcomeScreen.add(btnContinue);
		
	}

}
