package frames;


import questions.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import control.Controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RapidFireAnswer extends JFrame {

	private JPanel contentPane;
	JTextPane txtpnQuestions;
	JTextPane txtpnAnswers;
	private JTextPane txtpnAnswers_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RapidFireAnswer frame = new RapidFireAnswer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RapidFireAnswer() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtpnQuestions = new JTextPane();
		txtpnQuestions.setForeground(Color.WHITE);
		txtpnQuestions.setBackground(Color.BLACK);
		txtpnQuestions.setFont(new Font("Segoe UI", Font.BOLD, 40));
		txtpnQuestions.setEditable(false);
		
		txtpnQuestions.setBounds(131, 150, 917, 857);
		/*StyledDocument doc = txtpnQuestions.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);*/
		
		
		contentPane.add(txtpnQuestions);
		
		txtpnAnswers = new JTextPane();
		txtpnAnswers.setForeground(Color.WHITE);
		txtpnAnswers.setBackground(Color.BLACK);
		txtpnAnswers.setFont(new Font("Segoe UI", Font.BOLD, 40));
		txtpnAnswers.setEditable(false);
		txtpnAnswers.setBounds(1060, 150, 848, 857);
		contentPane.add(txtpnAnswers);
		
		txtpnAnswers_1 = new JTextPane();
		txtpnAnswers_1.setFont(new Font("Segoe UI", Font.BOLD, 60));
		txtpnAnswers_1.setForeground(Color.GREEN);
		txtpnAnswers_1.setBackground(Color.BLACK);
		txtpnAnswers_1.setEditable(false);
		txtpnAnswers_1.setText("Answers");
		txtpnAnswers_1.setBounds(834, 49, 246, 89);
		contentPane.add(txtpnAnswers_1);
		
		JButton btnBackToGroup = new JButton("Back to Group Selection");
		btnBackToGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RapidFire.counter=0;
				Controller.group="none";
				RapidFire.t.cancel(false);
				Controller.time=60;
				Controller.rapidFireTeamSelection.setVisible(true);
				Controller.rapidFireAnswers.dispose();
			}
		});
		btnBackToGroup.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		btnBackToGroup.setBounds(131, 60, 275, 75);
		contentPane.add(btnBackToGroup);
		
		showAnswers();
	}
	public void showAnswers()
	{
		for(int i=0;i<Question.counter;i++)
		{
			if(Controller.group.equals("one"))
			{
				txtpnQuestions.setText(txtpnQuestions.getText()+Question.queGrpOne[i][0]+"\n");
				txtpnAnswers.setText(txtpnAnswers.getText()+Question.queGrpOne[i][1]+"\n");
			}
			else if(Controller.group.equals("two"))
			{
				txtpnQuestions.setText(txtpnQuestions.getText()+Question.queGrpTwo[i][0]+"\n");
				txtpnAnswers.setText(txtpnAnswers.getText()+Question.queGrpTwo[i][1]+"\n");
			}
			else if(Controller.group.equals("three"))
			{
				txtpnQuestions.setText(txtpnQuestions.getText()+Question.queGrpThree[i][0]+"\n");
				txtpnAnswers.setText(txtpnAnswers.getText()+Question.queGrpThree[i][1]+"\n");
			}
			else if(Controller.group.equals("four"))
			{
				txtpnQuestions.setText(txtpnQuestions.getText()+Question.queGrpFour[i][0]+"\n");
				txtpnAnswers.setText(txtpnAnswers.getText()+Question.queGrpFour[i][1]+"\n");
			}
		}
	}
}
