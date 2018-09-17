package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import control.Controller;

import java.awt.Frame;
import java.awt.Color;
import java.awt.Component;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AudioDisplayFrame extends JFrame {

	private JPanel contentPane;
	String audioPath;
	static JTextPane txtpnStatus,txtpnClue;
	static ScheduledFuture<?> t;
	static long time=45,timerTime;
	static Clip audio;
	static Thread timer;
	AudioInputStream audioInputStream;
	JButton btnPlay;
	boolean clicked;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AudioDisplayFrame frame = new AudioDisplayFrame();
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
	public AudioDisplayFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBackToAudio = new JButton("<-- Back");
		btnBackToAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(clicked==true)
				{t.cancel(false);
				AudioDisplayFrame.time=45;
				audio.stop();
				audio.close();}
				AudioSelection as=new AudioSelection();
				Controller.audioSelection=as;
				Controller.audioSelection.setVisible(true);
				Controller.audioDisplayFrame.dispose();
			}
		});
		btnBackToAudio.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnBackToAudio.setBounds(117, 80, 144, 65);
		contentPane.add(btnBackToAudio);
		
		JButton btnShowAnswer = new JButton("Show Answer");
		btnShowAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t.cancel(false);
				StyledDocument doc = txtpnStatus.getStyledDocument();
				SimpleAttributeSet center = new SimpleAttributeSet();
				StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
				doc.setParagraphAttributes(0, doc.getLength(), center, false);
				txtpnStatus.setFont(new Font("Segoe UI", Font.BOLD, 50));
				if(Controller.audio.equals("speech1"))
				{
					txtpnStatus.setText("Answer : Sania Mirza");
				}
				else if(Controller.audio.equals("speech2"))
				{
					txtpnStatus.setText("Answer : Martin Luther King");
				}
				else if(Controller.audio.equals("speech3"))
				{
					txtpnStatus.setText("Answer : Nelson Mandela");
				}
				else if(Controller.audio.equals("speech4"))
				{
					txtpnStatus.setText("Answer : PV Sindhu");
				}
				else if(Controller.audio.equals("audio1"))
				{
					txtpnStatus.setText("Answer : Ravi Shastri");
				}
				else if(Controller.audio.equals("audio2"))
				{
					txtpnStatus.setText("Answer : Chak De India");
				}
				else if(Controller.audio.equals("audio3"))
				{
					txtpnStatus.setText("Answer : Yuvraj Singh");
				}
				else if(Controller.audio.equals("audio4"))
				{
					txtpnStatus.setText("Answer : Xylophone");
				}
				
			}
		});
		btnShowAnswer.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnShowAnswer.setBounds(1605, 80, 178, 65);
		contentPane.add(btnShowAnswer);
		
		JButton btnClue = new JButton("Show Clue");
		btnClue.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btnClue.setBounds(1605, 831, 171, 73);
		contentPane.add(btnClue);
		
		txtpnClue = new JTextPane();
		txtpnClue.setForeground(Color.GREEN);
		txtpnClue.setEditable(false);
		txtpnClue.setFont(new Font("Segoe UI", Font.BOLD, 50));
		txtpnClue.setBackground(Color.BLACK);
		txtpnClue.setText("Need a CLUE?");
		txtpnClue.setBounds(117, 816, 1407, 185);
		contentPane.add(txtpnClue);
		
		JLabel lblImage=new JLabel("",JLabel.CENTER);
		lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblImage.setBounds(117, 302, 467, 409);
		lblImage.setIcon(new ImageIcon(AudioDisplayFrame.class.getResource("/images/mic.jpg"))); 
		contentPane.add(lblImage);
		
		txtpnStatus = new JTextPane();
		txtpnStatus.setBackground(Color.BLACK);
		txtpnStatus.setForeground(Color.GREEN);
		txtpnStatus.setFont(new Font("Segoe UI", Font.BOLD, 50));
		txtpnStatus.setEditable(false);
		txtpnStatus.setText("Click Play to begin Audio Clip.");
		txtpnStatus.setBounds(673, 441, 568, 173);
		contentPane.add(txtpnStatus);
		
		JTextPane txtpnRecognizeTheAudio = new JTextPane();
		txtpnRecognizeTheAudio.setForeground(Color.GREEN);
		txtpnRecognizeTheAudio.setBackground(Color.BLACK);
		txtpnRecognizeTheAudio.setFont(new Font("Segoe UI", Font.BOLD, 50));
		txtpnRecognizeTheAudio.setText("RECOGNIZE THE AUDIO");
		txtpnRecognizeTheAudio.setEditable(false);
		txtpnRecognizeTheAudio.setBounds(673, 77, 568, 73);
		contentPane.add(txtpnRecognizeTheAudio);
		try {
		
		if(Controller.audio.equals("speech1"))
		{
			Controller.speech1="selected";
			audioPath="/sounds/speech/Hingis and Mirza womens doubles champions  Australian Open 2016.wav";
		}
		else if(Controller.audio.equals("speech2"))
		{
			Controller.speech2="selected";
			audioPath="/sounds/speech/Martin Luther King Jr.wav";
		}
		else if(Controller.audio.equals("speech3"))
		{
			Controller.speech3="selected";
			audioPath="/sounds/speech/Nelson Mandela at Harvard.wav";
		}
		else if(Controller.audio.equals("speech4"))
		{
			Controller.speech4="selected";
			audioPath="/sounds/speech/PV Sindhu Gives Her Victory Speech  Full Video Interview.wav";
		}
		else if(Controller.audio.equals("audio1"))
		{
			Controller.audio1="selected";
			audioPath="/sounds/audio/Identify the commentator_Group I.wav";
		}
		else if(Controller.audio.equals("audio2"))
		{
			Controller.audio2="selected";
			audioPath="/sounds/audio/Identify the movie from the song_Group III.wav";
		}
		else if(Controller.audio.equals("audio3"))
		{
			Controller.audio3="selected";
			audioPath="/sounds/audio/yuvraj.wav";
		}
		else if(Controller.audio.equals("audio4"))
		{
			Controller.audio4="selected";
			audioPath="/sounds/audio/Identify the Musical Instrument_Group IV.wav";
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		JButton btnStop= new JButton("STOP");
		btnStop.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 45));
		btnStop.setBounds(1605, 462, 171, 73);
		contentPane.add(btnStop);
		btnStop.setVisible(false);
		
		btnPlay = new JButton("PLAY");
		btnPlay.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 45));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnStatus.setText("Playing Audio...");
				clicked=true;
				try {
					btnPlay.setVisible(false);
					btnStop.setVisible(true);
					audioInputStream = AudioSystem.getAudioInputStream(AudioDisplayFrame.class.getResource(audioPath));
					audio= AudioSystem.getClip();
					audio.open(audioInputStream);
					audio.start();
					
					StyledDocument doc = txtpnStatus.getStyledDocument();
					SimpleAttributeSet center = new SimpleAttributeSet();
					StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
					doc.setParagraphAttributes(0, doc.getLength(), center, false);
					
					ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
					t=executorService.scheduleAtFixedRate(AudioDisplayFrame::setTime, audio.getMicrosecondLength()+1000000, 1000000, TimeUnit.MICROSECONDS);
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		btnPlay.setBounds(1605, 463, 171, 71);
		contentPane.add(btnPlay);
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.setVisible(false);
				btnPlay.setVisible(true);
				audio.stop();
				audio.close();
				t.cancel(false);
				AudioDisplayFrame.time=45;
				txtpnStatus.setFont(new Font("Segoe UI", Font.BOLD, 50));
				txtpnStatus.setText("Click Play to begin Audio Clip.");
			}
		});
		
	}
	public static void setTime() {
		
		txtpnStatus.setFont(new Font("Segoe UI", Font.BOLD, 99));
		txtpnStatus.setText(""+AudioDisplayFrame.time);
		AudioDisplayFrame.time--;
		if(AudioDisplayFrame.time==0)
		{
			txtpnStatus.setText("TIME UP!");
			t.cancel(false);
		}
	}
}
