package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import control.Controller;
import questions.Question;

import java.awt.Frame;
import java.awt.Color;

import javax.sound.sampled.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;
//import java.awt.EventQueue;

import javax.swing.SwingConstants;
import java.awt.Component;
//import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
//import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;


public class QuestionFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel questionScreen;
	static ScheduledFuture<?> t;
	private static JTextPane txtpnTimer;
	public static int time;
	static JTextPane txtpnQuestionDisplaysHere;
	static Clip sound;
	static JButton btnOptionA,btnOptionB,btnOptionC,btnOptionD,btnShowOption;
	static ScheduledExecutorService executorService;
	static JPanel panel;
	static boolean clicked;
	
	public QuestionFrame() {
		setTitle("Question Frame");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		questionScreen = new JPanel();
		setContentPane(questionScreen);
		
		questionScreen.setForeground(Color.LIGHT_GRAY);
		questionScreen.setBackground(Color.BLACK);
		questionScreen.setBorder(new EmptyBorder(5, 5, 5, 5));
		executorService = Executors.newSingleThreadScheduledExecutor();
		
		txtpnQuestionDisplaysHere = new JTextPane();
		txtpnQuestionDisplaysHere.setForeground(Color.YELLOW);
		txtpnQuestionDisplaysHere.setBounds(137, 176, 1667, 213);
		txtpnQuestionDisplaysHere.setBackground(Color.BLACK);
		txtpnQuestionDisplaysHere.setEditable(false);
		txtpnQuestionDisplaysHere.setFont(new Font("Segoe UI", Font.BOLD, 70));
		StyledDocument doc = txtpnQuestionDisplaysHere.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		JButton btnNext = new JButton("Next -->");
		btnNext.setBounds(1622, 401, 182, 65);
		JButton btnBackToStandard = new JButton("<-- Back");
		btnBackToStandard.setBounds(87, 401, 182, 65);
		
		JTextPane txtpnQ = new JTextPane();
		txtpnQ.setBounds(861, 65, 191, 56);
		txtpnQ.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
		txtpnQ.setEditable(false);
		txtpnQ.setText("Question :");
		txtpnQ.setForeground(Color.GREEN);
		txtpnQ.setBackground(Color.BLACK);
		
				
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				nextQuestion();
				
			}
		});
		btnNext.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnBackToStandard.setFont(new Font("Segoe UI", Font.BOLD, 25));
		questionScreen.setLayout(null);
		questionScreen.add(txtpnQ);
		questionScreen.add(btnBackToStandard);
		questionScreen.add(btnNext);
		questionScreen.add(txtpnQuestionDisplaysHere);
		
		txtpnTimer = new JTextPane();
		txtpnTimer.setForeground(Color.GREEN);
		txtpnTimer.setBackground(Color.BLACK);
		txtpnTimer.setFont(new Font("Segoe UI", Font.BOLD, 70));
		txtpnTimer.setEditable(false);
		txtpnTimer.setText("timer");
		txtpnTimer.setBounds(877, 380, 157, 88);
		StyledDocument doc1 = txtpnTimer.getStyledDocument();
		SimpleAttributeSet center1 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
		doc1.setParagraphAttributes(0, doc1.getLength(), center1, false);
		questionScreen.add(txtpnTimer);
		txtpnTimer.setVisible(false);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(87, 522, 1717, 445);
		questionScreen.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		btnOptionA = new JButton("Option A");
		btnOptionA.setFont(new Font("Segoe UI", Font.BOLD, 45));
		btnOptionA.setBackground(Color.CYAN);
		btnOptionA.setBounds(50, 8, 788, 205);
		panel.add(btnOptionA);
		btnOptionA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Controller.click++;
				Question.selectedOption=btnOptionA.getText();
				boolean answer=Question.checkAnswer();
				if(Controller.click==1)
				{
					if(answer==true)
					{
						repaintTrue(btnOptionA);
						playCorrectSound();
						t.cancel(true);
					}
					else 
					{
						repaintFalse(btnOptionA);
						playWrongSound();
					}
				}
				else
				{
					if(answer==true)
					{
						repaintTrue(btnOptionA);
						playCorrectSound();
						t.cancel(true);
					}
					else 
					{
						t.cancel(true);
						checkOption(btnOptionA,btnOptionB,btnOptionC,btnOptionD);
						repaintFalse(btnOptionA);
						playWrongSound();
					}
				}
			}
		});
		
		btnOptionC = new JButton("Option C");
		btnOptionC.setFont(new Font("Segoe UI", Font.BOLD, 45));
		btnOptionC.setBackground(Color.CYAN);
		btnOptionC.setBounds(50, 228, 788, 205);
		panel.add(btnOptionC);
		btnOptionC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Controller.click++;
				Question.selectedOption=btnOptionC.getText();
				boolean answer=Question.checkAnswer();
				if(Controller.click==1)
				{
					if(answer==true)
					{
						repaintTrue(btnOptionC);
						t.cancel(true);
						playCorrectSound();
					}
					else 
					{
						repaintFalse(btnOptionC);
						playWrongSound();
					}
				}
				else
				{
					if(answer==true)
					{
						repaintTrue(btnOptionC);
						t.cancel(true);
						playCorrectSound();
					}
					else 
					{
						t.cancel(true);
						checkOption(btnOptionA,btnOptionB,btnOptionC,btnOptionD);
						repaintFalse(btnOptionC);
						playWrongSound();
					}
				}
			}
		});
		
		btnOptionB = new JButton("Option B");
		btnOptionB.setFont(new Font("Segoe UI", Font.BOLD, 45));
		btnOptionB.setBackground(Color.CYAN);
		btnOptionB.setBounds(917, 8, 788, 205);
		panel.add(btnOptionB);
		btnOptionB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Controller.click++;
				Question.selectedOption=btnOptionB.getText();
				boolean answer=Question.checkAnswer();
				if(Controller.click==1)
				{
					if(answer==true)
					{
						repaintTrue(btnOptionB);
						t.cancel(true);
						playCorrectSound();
					}
					else 
					{
						repaintFalse(btnOptionB);
						playWrongSound();
					}
				}
				else
				{
					if(answer==true)
					{
						repaintTrue(btnOptionB);
						t.cancel(true);
						playCorrectSound();
					}
					else 
					{
						t.cancel(true);
						checkOption(btnOptionA,btnOptionB,btnOptionC,btnOptionD);
						repaintFalse(btnOptionB);
						playWrongSound();
					}
				}
				
			}
		});
		
		btnOptionD = new JButton("Option D");
		btnOptionD.setFont(new Font("Segoe UI", Font.BOLD, 45));
		btnOptionD.setBackground(Color.CYAN);
		btnOptionD.setBounds(917, 228, 788, 205);
		panel.add(btnOptionD);
		btnOptionD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Controller.click++;
				Question.selectedOption=btnOptionD.getText();
				boolean answer=Question.checkAnswer();
				if(Controller.click==1)
				{
					if(answer==true)
					{
						repaintTrue(btnOptionD);
						t.cancel(true);
						playCorrectSound();
					}
					else 
					{
						repaintFalse(btnOptionD);
						playWrongSound();
					}
				}
				else
				{
					if(answer==true)
					{
						repaintTrue(btnOptionD);
						t.cancel(true);
						playCorrectSound();
					}
					else 
					{
						t.cancel(true);
						checkOption(btnOptionA,btnOptionB,btnOptionC,btnOptionD);
						repaintFalse(btnOptionD);
						playWrongSound();
					}
				}
			}
		});

		
		JTextPane txtpnA = new JTextPane();
		txtpnA.setForeground(Color.GREEN);
		txtpnA.setBackground(Color.BLACK);
		txtpnA.setFont(new Font("Segoe UI", Font.BOLD, 30));
		txtpnA.setEditable(false);
		txtpnA.setText("A.");
		txtpnA.setBounds(0, 8, 38, 50);
		panel.add(txtpnA);
		
		JTextPane txtpnB = new JTextPane();
		txtpnB.setForeground(Color.GREEN);
		txtpnB.setBackground(Color.BLACK);
		txtpnB.setText("B.");
		txtpnB.setFont(new Font("Segoe UI", Font.BOLD, 30));
		txtpnB.setEditable(false);
		txtpnB.setBounds(867, 8, 38, 50);
		panel.add(txtpnB);
		
		JTextPane txtpnC = new JTextPane();
		txtpnC.setForeground(Color.GREEN);
		txtpnC.setBackground(Color.BLACK);
		txtpnC.setText("C.");
		txtpnC.setFont(new Font("Segoe UI", Font.BOLD, 30));
		txtpnC.setEditable(false);
		txtpnC.setBounds(0, 228, 38, 50);
		panel.add(txtpnC);
		
		JTextPane txtpnD = new JTextPane();
		txtpnD.setForeground(Color.GREEN);
		txtpnD.setBackground(Color.BLACK);
		txtpnD.setText("D.");
		txtpnD.setFont(new Font("Segoe UI", Font.BOLD, 30));
		txtpnD.setEditable(false);
		txtpnD.setBounds(867, 228, 38, 50);
		panel.add(txtpnD);
		
		btnShowOption=new JButton("Show Options");
		btnShowOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				clicked=true;
				btnShowOption.setVisible(false);
				txtpnTimer.setVisible(true);
				panel.setVisible(true);
				t=executorService.scheduleAtFixedRate(QuestionFrame::setTime, 0, 1, TimeUnit.SECONDS);
			}
		});
		btnShowOption.setFont(new Font("Segoe UI", Font.BOLD, 60));
		btnShowOption.setBounds(613, 654, 687, 207);
		questionScreen.add(btnShowOption);
		
		btnBackToStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(clicked==true)
					t.cancel(false);
				Question.counter=0;
				Controller.standard=0;
				Controller.qframe.dispose();
			}
		});
		
		QuestionFrame.time=30;
		
		if(Controller.standard==6)
		{
			txtpnQuestionDisplaysHere.setText(Question.que_sixth[Question.counter][0]);
			btnOptionA.setText(Question.opt_sixth[Question.counter][0]);
			btnOptionB.setText(Question.opt_sixth[Question.counter][1]);
			btnOptionC.setText(Question.opt_sixth[Question.counter][2]);
			btnOptionD.setText(Question.opt_sixth[Question.counter][3]);
		}
		if(Controller.standard==7)
		{
			txtpnQuestionDisplaysHere.setText(Question.que_seventh[Question.counter][0]);
			btnOptionA.setText(Question.opt_seventh[Question.counter][0]);
			btnOptionB.setText(Question.opt_seventh[Question.counter][1]);
			btnOptionC.setText(Question.opt_seventh[Question.counter][2]);
			btnOptionD.setText(Question.opt_seventh[Question.counter][3]);
		}
		if(Controller.standard==8)
		{
			txtpnQuestionDisplaysHere.setText(Question.que_eighth[Question.counter][0]);
			btnOptionA.setText(Question.opt_eighth[Question.counter][0]);
			btnOptionB.setText(Question.opt_eighth[Question.counter][1]);
			btnOptionC.setText(Question.opt_eighth[Question.counter][2]);
			btnOptionD.setText(Question.opt_eighth[Question.counter][3]);
		}
		if(Controller.standard==9)
		{
			txtpnQuestionDisplaysHere.setText(Question.que_ninth[Question.counter][0]);
			btnOptionA.setText(Question.opt_ninth[Question.counter][0]);
			btnOptionB.setText(Question.opt_ninth[Question.counter][1]);
			btnOptionC.setText(Question.opt_ninth[Question.counter][2]);
			btnOptionD.setText(Question.opt_ninth[Question.counter][3]);
		}
		if(Controller.standard==10)
		{
			txtpnQuestionDisplaysHere.setText(Question.que_tenth[Question.counter][0]);
			btnOptionA.setText(Question.opt_tenth[Question.counter][0]);
			btnOptionB.setText(Question.opt_tenth[Question.counter][1]);
			btnOptionC.setText(Question.opt_tenth[Question.counter][2]);
			btnOptionD.setText(Question.opt_tenth[Question.counter][3]);
		}

		

	}
	public static void nextQuestion()
	{
		if(clicked==true)
			t.cancel(false);
		txtpnTimer.setForeground(Color.GREEN);
		QuestionFrame.time=30;
		panel.setVisible(false);
		txtpnTimer.setVisible(false);
		btnShowOption.setVisible(true);
		
		executorService = Executors.newSingleThreadScheduledExecutor();
		Controller.click=0;
		btnOptionA.setBackground(Color.CYAN);
		btnOptionB.setBackground(Color.CYAN);
		btnOptionC.setBackground(Color.CYAN);
		btnOptionD.setBackground(Color.CYAN);
		if(Controller.standard==6)
		{
			if(Question.counter<Question.que_sixth.length-1)
			{
				Question.counter++;
				txtpnQuestionDisplaysHere.setText(Question.que_sixth[Question.counter][0]);
				btnOptionA.setText(Question.opt_sixth[Question.counter][0]);
				btnOptionB.setText(Question.opt_sixth[Question.counter][1]);
				btnOptionC.setText(Question.opt_sixth[Question.counter][2]);
				btnOptionD.setText(Question.opt_sixth[Question.counter][3]);
			}
			else
			{
				txtpnQuestionDisplaysHere.setText("All Questions have already been displayed");
				btnOptionA.setText("N/A");
				btnOptionB.setText("N/A");
				btnOptionC.setText("N/A");
				btnOptionD.setText("N/A");
				btnShowOption.setVisible(false);
			}
		}
		else if(Controller.standard==7)
		{
			if(Question.counter<Question.que_seventh.length-1)
			{
				Question.counter++;
				txtpnQuestionDisplaysHere.setText(Question.que_seventh[Question.counter][0]);
				btnOptionA.setText(Question.opt_seventh[Question.counter][0]);
				btnOptionB.setText(Question.opt_seventh[Question.counter][1]);
				btnOptionC.setText(Question.opt_seventh[Question.counter][2]);
				btnOptionD.setText(Question.opt_seventh[Question.counter][3]);
			}
			else
			{
				txtpnQuestionDisplaysHere.setText("All Questions have already been displayed");
				btnOptionA.setText("N/A");
				btnOptionB.setText("N/A");
				btnOptionC.setText("N/A");
				btnOptionD.setText("N/A");
				btnShowOption.setVisible(false);
			}
		}
		else if(Controller.standard==8)
		{
			if(Question.counter<Question.que_eighth.length-1)
			{
				Question.counter++;
				txtpnQuestionDisplaysHere.setText(Question.que_eighth[Question.counter][0]);
				btnOptionA.setText(Question.opt_eighth[Question.counter][0]);
				btnOptionB.setText(Question.opt_eighth[Question.counter][1]);
				btnOptionC.setText(Question.opt_eighth[Question.counter][2]);
				btnOptionD.setText(Question.opt_eighth[Question.counter][3]);
			}
			else
			{
				txtpnQuestionDisplaysHere.setText("All Questions have already been displayed");
				btnOptionA.setText("N/A");
				btnOptionB.setText("N/A");
				btnOptionC.setText("N/A");
				btnOptionD.setText("N/A");
				btnShowOption.setVisible(false);
			}
		}
		else if(Controller.standard==9)
		{
			if(Question.counter<Question.que_ninth.length-1)
			{
				Question.counter++;
				txtpnQuestionDisplaysHere.setText(Question.que_ninth[Question.counter][0]);
				btnOptionA.setText(Question.opt_ninth[Question.counter][0]);
				btnOptionB.setText(Question.opt_ninth[Question.counter][1]);
				btnOptionC.setText(Question.opt_ninth[Question.counter][2]);
				btnOptionD.setText(Question.opt_ninth[Question.counter][3]);
			}
			else
			{
				txtpnQuestionDisplaysHere.setText("All Questions have already been displayed");
				btnOptionA.setText("N/A");
				btnOptionB.setText("N/A");
				btnOptionC.setText("N/A");
				btnOptionD.setText("N/A");
				btnShowOption.setVisible(false);
			}
		}
		else if(Controller.standard==10)
		{
			if(Question.counter<Question.que_tenth.length-1)
			{
				Question.counter++;
				txtpnQuestionDisplaysHere.setText(Question.que_tenth[Question.counter][0]);
				btnOptionA.setText(Question.opt_tenth[Question.counter][0]);
				btnOptionB.setText(Question.opt_tenth[Question.counter][1]);
				btnOptionC.setText(Question.opt_tenth[Question.counter][2]);
				btnOptionD.setText(Question.opt_tenth[Question.counter][3]);
			}
			else
			{
				txtpnQuestionDisplaysHere.setText("All Questions have already been displayed");
				btnOptionA.setText("N/A");
				btnOptionB.setText("N/A");
				btnOptionC.setText("N/A");
				btnOptionD.setText("N/A");
				btnShowOption.setVisible(false);
			}
				
		}
		
	}
	
	public static void setTime() {
		txtpnTimer.setText(""+QuestionFrame.time);
		QuestionFrame.time--;
		if(QuestionFrame.time==2)
			txtpnTimer.setForeground(Color.RED);
		if(QuestionFrame.time==-2)
		{
			nextQuestion();
		}
	}

	public static void checkOption(JButton btnOptionA,JButton btnOptionB,JButton btnOptionC,JButton btnOptionD)
	{
		if(!(Question.correctOption.equals(Question.selectedOption)))
		{
			if(btnOptionA.getText()==Question.correctOption)
			{
				btnOptionA.setBackground(Color.GREEN);
			}
			else if(btnOptionB.getText().equals(Question.correctOption))
			{
				btnOptionB.setBackground(Color.GREEN);
			}
			else if(btnOptionC.getText().equals(Question.correctOption))
			{
				btnOptionC.setBackground(Color.GREEN);
			}
			else if(btnOptionD.getText().equals(Question.correctOption))
			{
				btnOptionD.setBackground(Color.GREEN);
			}
		}
		
	}
	
	public static void repaintTrue(JButton btn)
	{
		btn.setBackground(Color.GREEN);
	}
	
	public static void repaintFalse(JButton btn)
	{
		btn.setBackground(Color.RED);
	}
	
	public static void playWrongSound()
	{
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(QuestionFrame.class.getResource("/sounds/wrongsound.wav"));
			sound= AudioSystem.getClip();
			sound.open(audioInputStream);
			sound.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void playCorrectSound()
	{
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(QuestionFrame.class.getResource("/sounds/correctsound.wav"));
			sound= AudioSystem.getClip();
			sound.open(audioInputStream);
			sound.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}