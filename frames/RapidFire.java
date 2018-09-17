package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import control.Controller;
import questions.Question;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import frames.RapidFireAnswer;

@SuppressWarnings("serial")
public class RapidFire extends JFrame {

	private static JTextPane txtpnTimer;
	private static JTextPane txtpnQuestion;
	static int counter;
	private JPanel contentPane;
	static ScheduledFuture<?> t;
	static JButton btnNext,btnShowAnswer;
	static JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RapidFire frame = new RapidFire();
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
	public RapidFire() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtpnQuestion= new JTextPane();
		txtpnQuestion.setForeground(Color.WHITE);
		txtpnQuestion.setBackground(Color.BLACK);
		txtpnQuestion.setEditable(false);
		txtpnQuestion.setFont(new Font("Segoe UI", Font.BOLD, 80));
		txtpnQuestion.setText("Question");
		txtpnQuestion.setBounds(348, 281, 1217, 492);
		contentPane.add(txtpnQuestion);
		StyledDocument doc = txtpnQuestion.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		
		if(Controller.group.equals("one"))
		{
			txtpnQuestion.setText(Question.queGrpOne[counter][0]);
			counter++;
		}
		else if(Controller.group.equals("two"))
		{
			txtpnQuestion.setText(Question.queGrpTwo[counter][0]);
			counter++;
		}
		else if(Controller.group.equals("three"))
		{
			txtpnQuestion.setText(Question.queGrpThree[counter][0]);
			counter++;
		}
		else if(Controller.group.equals("four"))
		{
			txtpnQuestion.setText(Question.queGrpFour[counter][0]);
			counter++;
		}
		
		txtpnTimer = new JTextPane();
		txtpnTimer.setForeground(Color.GREEN);
		txtpnTimer.setBackground(Color.BLACK);
		txtpnTimer.setEditable(false);
		txtpnTimer.setFont(new Font("Segoe UI", Font.BOLD, 80));
		txtpnTimer.setText("Timer");
		txtpnTimer.setBounds(829, 78, 256, 135);
		contentPane.add(txtpnTimer);
		StyledDocument doc1 = txtpnTimer.getStyledDocument();
		SimpleAttributeSet center1 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
		doc1.setParagraphAttributes(0, doc1.getLength(), center1, false);
		
		JButton button = new JButton("<--");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				counter=0;
				Controller.group="none";
				t.cancel(false);
				Controller.time=60;
				Controller.rapidFire.dispose();
			}
		});
		button.setFont(new Font("Microsoft YaHei", Font.BOLD, 35));
		button.setBounds(194, 102, 115, 75);
		contentPane.add(button);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(684, 806, 545, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnShowAnswer = new JButton("Show Answer");
		btnShowAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				showAnswer();
			}});
		btnShowAnswer.setBounds(88, 5, 369, 84);
		btnShowAnswer.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 35));
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if(Controller.time!=-1)
					{
						if(counter<Question.queGrpOne.length)
						{
							if(Controller.group.equals("one"))
							{
								txtpnQuestion.setText(Question.queGrpOne[counter][0]);
								counter++;
							}
							else if(Controller.group.equals("two"))
							{
								txtpnQuestion.setText(Question.queGrpTwo[counter][0]);
								counter++;
							}
							else if(Controller.group.equals("three"))
							{
								txtpnQuestion.setText(Question.queGrpThree[counter][0]);
								counter++;
							}
							else if(Controller.group.equals("four"))
							{
								txtpnQuestion.setText(Question.queGrpFour[counter][0]);
								counter++;
							}
						}
						else
						{
								txtpnQuestion.setText("CONGRATULATIONS! \nYou completed all questions!");
								t.cancel(false);
								panel.remove(btnNext);
								panel.add(btnShowAnswer);
								panel.revalidate();
								panel.repaint();
						}	
					}
					else 
					{
							txtpnQuestion.setText("SORRY! TIME UP!");
							panel.remove(btnNext);
							panel.add(btnShowAnswer);
							panel.revalidate();
							panel.repaint();
							
					}
			}
		});
		btnNext.setBounds(155, 5, 235, 84);
		btnNext.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 35));
		panel.add(btnNext);
		
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		t=executorService.scheduleAtFixedRate(RapidFire::setTime, 0, 1, TimeUnit.SECONDS);

	}
	
	public static void setTime() {
		txtpnTimer.setText(""+Controller.time);
		Controller.time--;
		if(Controller.time==-1)
		{
			panel.remove(btnNext);
			panel.add(btnShowAnswer);
			panel.revalidate();
			panel.repaint();
			txtpnQuestion.setText("TIME UP");
			t.cancel(false);
		}
	}
	
	public static void showAnswer() {
		RapidFireAnswer rapidFireAnswers=new RapidFireAnswer();
		Controller.rapidFireAnswers=rapidFireAnswers;
		rapidFireAnswers.setVisible(true);
		Controller.rapidFire.dispose();
	}
}
