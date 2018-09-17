package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import control.Controller;
import frames.SpectrumRoundFrame;

import java.awt.Frame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DisplayQuestion extends JFrame {

	private JPanel contentPane;
	private static JLabel lblImage;
	static JTextPane txtpnTimer;
	static ScheduledFuture<?> t;
	static JTextPane txtpnQuestionPane;
	static int time=45;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayQuestion frame = new DisplayQuestion();
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
	public DisplayQuestion() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblImage=new JLabel("",JLabel.CENTER);
		lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtpnQuestionPane = new JTextPane();
		txtpnQuestionPane.setBackground(Color.LIGHT_GRAY);
		txtpnQuestionPane.setBounds(137, 667, 1640, 178);
		txtpnQuestionPane.setEditable(false);
		txtpnQuestionPane.setFont(new Font("Segoe UI", Font.BOLD, 50));
		txtpnQuestionPane.setText("Question Pane");
		StyledDocument doc = txtpnQuestionPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		//lblImage = new JLabel(new ImageIcon("G:/eclipse Workspace/TIME Repeat/bin/images/gandhi.png"));
		lblImage.setBounds(547, 144, 819, 489);
		
		JButton btnNeedAClue = new JButton("Need a CLUE?");
		btnNeedAClue.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		btnNeedAClue.setBounds(134, 893, 212, 68);
		contentPane.add(btnNeedAClue);
		
		JTextPane txtpnClue = new JTextPane();
		txtpnClue.setFont(new Font("Segoe UI", Font.BOLD, 27));
		txtpnClue.setBackground(Color.LIGHT_GRAY);
		txtpnClue.setEditable(false);
		txtpnClue.setBounds(390, 893, 1387, 63);
		contentPane.add(txtpnClue);
		txtpnClue.setVisible(false);
		
		txtpnClue.setBackground(new Color(255,222,173));
		txtpnQuestionPane.setBackground(new Color(255,222,173));
		
		if(Controller.color=="violet")
		{
			contentPane.setBackground(new Color(148, 0, 211));
			lblImage.setIcon(new ImageIcon(DisplayQuestion.class.getResource("/images/sudha chandran.jpg"))); 
			txtpnQuestionPane.setText("Identify the artist above!");
			btnNeedAClue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					txtpnClue.setVisible(true);
					txtpnClue.setText("A 'divyang' women who became one of the most popular classical dancers of India.");
				}
			});
			Controller.violet="selected";
		}
		else if(Controller.color=="indigo")
		{
			contentPane.setBackground(new Color(75, 0, 130));
			lblImage.setIcon(new ImageIcon(DisplayQuestion.class.getResource("/images/pamir.jpg")));  
			txtpnQuestionPane.setText("Identify this plateau ?");
			btnNeedAClue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					txtpnClue.setVisible(true);
					txtpnClue.setText("It is the highest plateau in Tibet.");
				}
			});
			Controller.indigo="selected";
		}
		else if(Controller.color=="blue")
		{
			contentPane.setBackground(Color.BLUE);
			lblImage.setIcon(new ImageIcon(DisplayQuestion.class.getResource("/images/charles-dickens.jpg")));  
			txtpnQuestionPane.setText("Identify the famous writer above!");
			btnNeedAClue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					txtpnClue.setVisible(true);
					txtpnClue.setText("Author of Oliver Twist.");
				}
			});
			Controller.blue="selected";
		}
		else if(Controller.color=="green")
		{
			contentPane.setBackground(Color.GREEN);
			lblImage.setIcon(new ImageIcon(DisplayQuestion.class.getResource("/images/hemlock.jpg")));  
			txtpnQuestionPane.setText("Identify this special plant above!");
			btnNeedAClue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					txtpnClue.setVisible(true);
					txtpnClue.setText("Highly poisonous plant. Causes paralysis, inability of breath and heart failure.");
				}
			});
			Controller.green="selected";
		}
		else if(Controller.color=="yellow")
		{
			contentPane.setBackground(Color.YELLOW);
			lblImage.setIcon(new ImageIcon(DisplayQuestion.class.getResource("/images/roger-federer.jpg")));  
			txtpnQuestionPane.setText("Identify this Proffessional Athlete!");
			btnNeedAClue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					txtpnClue.setVisible(true);
					txtpnClue.setText("A Swiss Tennis player popularly known as Fed-Ex.");
				}
			});
			Controller.yellow="selected";
		}
		else if(Controller.color=="orange")
		{
			contentPane.setBackground(Color.ORANGE);
			lblImage.setIcon(new ImageIcon(DisplayQuestion.class.getResource("/images/Vikram-Sarabhai-1.jpg")));  
			txtpnQuestionPane.setText("Identify this reknowned Indian Scientist !");
			btnNeedAClue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					txtpnClue.setVisible(true);
					txtpnClue.setText("Father of Indian Space Programme.");
				}
			});
			Controller.orange="selected";
		}
		else if(Controller.color=="red")
		{
			contentPane.setBackground(Color.RED);
			txtpnClue.setBackground(new Color(255,222,173));
			txtpnQuestionPane.setBackground(new Color(255,222,173));
			lblImage.setIcon(new ImageIcon(DisplayQuestion.class.getResource("/images/razia sultan.gif")));  
			txtpnQuestionPane.setText("Identify this Woman Sultan!");
			btnNeedAClue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					txtpnClue.setVisible(true);
					txtpnClue.setText("The first woman to rule Delhi.");
				}
			});
			Controller.red="selected";
		}
		else if(Controller.color=="white")
		{
			contentPane.setBackground(Color.WHITE);
			txtpnClue.setBackground(new Color(255,222,173));
			txtpnQuestionPane.setBackground(new Color(255,222,173));
			lblImage.setIcon(new ImageIcon(DisplayQuestion.class.getResource("/images/saint chavara.jpg")));  
			txtpnQuestionPane.setText("Identify the Saint.");
			btnNeedAClue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					txtpnClue.setVisible(true);
					txtpnClue.setText("He is the founder of our School.");
				}
			});
			Controller.white="selected";
		}
		contentPane.setLayout(null);
		contentPane.add(txtpnQuestionPane);
		contentPane.add(lblImage);
		
		JButton button = new JButton("<--Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				t.cancel(false);
				DisplayQuestion.time=45;
				SpectrumRoundFrame spectrum=new SpectrumRoundFrame();
				Controller.spectrumRound=spectrum;
				spectrum.setVisible(true);
				Controller.display.dispose();
			}
		});
		button.setBackground(Color.CYAN);
		button.setFont(new Font("Segoe UI", Font.BOLD, 23));
		button.setBounds(136, 58, 138, 63);
		contentPane.add(button);
		
		JButton btnShowAnswer = new JButton("Show Answer");
		btnShowAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				t.cancel(false);
				if(Controller.color=="violet")
				{
					txtpnQuestionPane.setText("Answer: Sudha Chandran");
				}
				else if(Controller.color=="indigo")
				{
					txtpnQuestionPane.setText("Answer: Pamir");
				}
				else if(Controller.color=="blue")
				{
					txtpnQuestionPane.setText("Answer: Charles Dickens");
				}
				else if(Controller.color=="green")
				{
					txtpnQuestionPane.setText("Answer: Hemlock Plant");
				}
				else if(Controller.color=="yellow")
				{
					txtpnQuestionPane.setText("Answer: Roger Federer");
				}
				else if(Controller.color=="orange")
				{
					txtpnQuestionPane.setText("Answer: Vikram Sarabhai");
				}
				else if(Controller.color=="red")
				{
					txtpnQuestionPane.setText("Answer: Razia Sultan");
				}
				else if(Controller.color=="white")
				{
					txtpnQuestionPane.setText("Answer: Saint Kuriakose Elias Chavara");
				}
			}
		});
		btnShowAnswer.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnShowAnswer.setBackground(Color.CYAN);
		btnShowAnswer.setBounds(1579, 58, 198, 63);
		contentPane.add(btnShowAnswer);
		
		txtpnTimer = new JTextPane();
		txtpnTimer.setFont(new Font("Segoe UI", Font.BOLD, 60));
		txtpnTimer.setBackground(new Color(255,222,173));
		txtpnTimer.setForeground(Color.DARK_GRAY);
		txtpnTimer.setEditable(false);
		StyledDocument doc1 = txtpnTimer.getStyledDocument();
		SimpleAttributeSet center1 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
		doc1.setParagraphAttributes(0, doc1.getLength(), center1, false);
		txtpnTimer.setText("timer");
		txtpnTimer.setBounds(901, 38, 111, 96);
		contentPane.add(txtpnTimer);
		
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		t=executorService.scheduleAtFixedRate(DisplayQuestion::setTime, 0, 1, TimeUnit.SECONDS);
	}
	public static void setTime() {
		txtpnTimer.setText(""+DisplayQuestion.time);
		DisplayQuestion.time--;
		if(DisplayQuestion.time==-1)
		{
			txtpnQuestionPane.setText("TIME UP");
			t.cancel(false);
			lblImage.setVisible(false);
		}
	}
}
