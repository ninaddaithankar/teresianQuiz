package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import control.Controller;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AudioSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AudioSelection frame = new AudioSelection();
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
	public AudioSelection() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnAudioRound = new JTextPane();
		txtpnAudioRound.setBounds(799, 73, 316, 60);
		txtpnAudioRound.setFont(new Font("Segoe UI", Font.BOLD, 50));
		txtpnAudioRound.setBackground(Color.BLACK);
		txtpnAudioRound.setForeground(Color.GREEN);
		txtpnAudioRound.setEnabled(true);
		txtpnAudioRound.setEditable(false);
		txtpnAudioRound.setText("Audio Round");
		
		JSeparator separator = new JSeparator();
		separator.setBounds(635, 179, 644, 2);
		
		JPanel panel = new JPanel();
		panel.setBounds(267, 284, 1390, 626);
		
		JButton button = new JButton("<<-Back");
		button.setBounds(104, 73, 145, 60);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Controller.audioSelection.dispose();
			}
		});
		button.setFont(new Font("Segoe UI", Font.BOLD, 23));
		panel.setLayout(new GridLayout(2, 4, 0, 0));
		panel.setBackground(Color.BLACK);
		
		JButton btnSpeech1 = new JButton();
		
		btnSpeech1.setForeground(Color.BLACK);
		btnSpeech1.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
		if(Controller.speech1.equals("selected"))
		{
			btnSpeech1.setBackground(Color.DARK_GRAY);
			btnSpeech1.setText("Already Selected!");
			btnSpeech1.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			btnSpeech1.setForeground(Color.WHITE);
		}
		else 
		{
			btnSpeech1.setIcon(new ImageIcon(AudioSelection.class.getResource("/images/mic for buttons.jpg")));
			btnSpeech1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					
					Controller.audio="speech1";
					AudioDisplayFrame audioDisplayFrame=new AudioDisplayFrame();
					Controller.audioDisplayFrame=audioDisplayFrame;
					audioDisplayFrame.setVisible(true);
					Controller.audioSelection.dispose();
				}
			});
		}
		panel.add(btnSpeech1);
		
		JButton btnSpeech2 = new JButton();
		
		if(Controller.speech2.equals("selected"))
		{
			btnSpeech2.setBackground(Color.DARK_GRAY);
			btnSpeech2.setText("Already Selected!");
			btnSpeech2.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			btnSpeech2.setForeground(Color.WHITE);
		}
		else 
		{
			btnSpeech2.setIcon(new ImageIcon(AudioSelection.class.getResource("/images/mic for buttons.jpg")));
			btnSpeech2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Controller.audio="speech2";
					AudioDisplayFrame audioDisplayFrame=new AudioDisplayFrame();
					Controller.audioDisplayFrame=audioDisplayFrame;
					audioDisplayFrame.setVisible(true);
					Controller.audioSelection.dispose();
				}
			});
			btnSpeech2.setForeground(Color.WHITE);
			btnSpeech2.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
		}
		panel.add(btnSpeech2);
		
		JButton btnSpeech3 = new JButton();
		
		if(Controller.speech3.equals("selected"))
		{
			btnSpeech3.setBackground(Color.DARK_GRAY);
			btnSpeech3.setText("Already Selected!");
			btnSpeech3.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			btnSpeech3.setForeground(Color.WHITE);
		}
		else
		{
			btnSpeech3.setIcon(new ImageIcon(AudioSelection.class.getResource("/images/mic for buttons.jpg")));
			btnSpeech3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Controller.audio="speech3";
					AudioDisplayFrame audioDisplayFrame=new AudioDisplayFrame();
					Controller.audioDisplayFrame=audioDisplayFrame;
					audioDisplayFrame.setVisible(true);
					Controller.audioSelection.dispose();
				}
			});
			btnSpeech3.setForeground(Color.WHITE);
			btnSpeech3.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			
		}
		panel.add(btnSpeech3);
		
		JButton btnSpeech4 = new JButton();
		
		if(Controller.speech4.equals("selected"))
		{
			btnSpeech4.setBackground(Color.DARK_GRAY);
			btnSpeech4.setText("Already Selected!");
			btnSpeech4.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			btnSpeech4.setForeground(Color.WHITE);
		}
		else
		{
			btnSpeech4.setIcon(new ImageIcon(AudioSelection.class.getResource("/images/mic for buttons.jpg")));
			btnSpeech4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Controller.audio="speech4";
				AudioDisplayFrame audioDisplayFrame=new AudioDisplayFrame();
				Controller.audioDisplayFrame=audioDisplayFrame;
				audioDisplayFrame.setVisible(true);
				Controller.audioSelection.dispose();
			}
		});
		btnSpeech4.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			
		}
		
		panel.add(btnSpeech4);
		
		JButton btnAudio1 = new JButton();
		
		if(Controller.audio1.equals("selected"))
		{
			btnAudio1.setBackground(Color.DARK_GRAY);
			btnAudio1.setText("Already Selected!");
			btnAudio1.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			btnAudio1.setForeground(Color.WHITE);
		}
		else
		{
			btnAudio1.setIcon(new ImageIcon(AudioSelection.class.getResource("/images/audio for btns.jpg")));
			btnAudio1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Controller.audio="audio1";
					AudioDisplayFrame audioDisplayFrame=new AudioDisplayFrame();
					Controller.audioDisplayFrame=audioDisplayFrame;
					audioDisplayFrame.setVisible(true);
					Controller.audioSelection.dispose();
				}
			});
			btnAudio1.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
		}
		
		panel.add(btnAudio1);
		
		JButton btnAudio2 = new JButton();
		
		if(Controller.audio2.equals("selected"))
		{
			btnAudio2.setBackground(Color.DARK_GRAY);
			btnAudio2.setText("Already Selected!");
			btnAudio2.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			btnAudio2.setForeground(Color.WHITE);
		}
		else
		{
			btnAudio2.setIcon(new ImageIcon(AudioSelection.class.getResource("/images/audio for btns.jpg")));
			btnAudio2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Controller.audio="audio2";
					AudioDisplayFrame audioDisplayFrame=new AudioDisplayFrame();
					Controller.audioDisplayFrame=audioDisplayFrame;
					audioDisplayFrame.setVisible(true);
					Controller.audioSelection.dispose();
				}
			});
			btnAudio2.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
		}
		
		panel.add(btnAudio2);
		
		JButton btnAudio3 = new JButton();
		
		if(Controller.audio3.equals("selected"))
		{
			btnAudio3.setBackground(Color.DARK_GRAY);
			btnAudio3.setText("Already Selected!");
			btnAudio3.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			btnAudio3.setForeground(Color.WHITE);
		}
		else
		{
			btnAudio3.setIcon(new ImageIcon(AudioSelection.class.getResource("/images/audio for btns.jpg")));
			btnAudio3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Controller.audio="audio3";
					AudioDisplayFrame audioDisplayFrame=new AudioDisplayFrame();
					Controller.audioDisplayFrame=audioDisplayFrame;
					audioDisplayFrame.setVisible(true);
					Controller.audioSelection.dispose();
				}
			});
			btnAudio3.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
		}
		
		panel.add(btnAudio3);
		
		JButton btnAudio4 = new JButton();
		
		if(Controller.audio4.equals("selected"))
		{
			btnAudio4.setBackground(Color.DARK_GRAY);
			btnAudio4.setText("Already Selected!");
			btnAudio4.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
			btnAudio4.setForeground(Color.WHITE);
		}
		else
		{
			btnAudio4.setIcon(new ImageIcon(AudioSelection.class.getResource("/images/audio for btns.jpg")));
			btnAudio4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Controller.audio="audio4";
					AudioDisplayFrame audioDisplayFrame=new AudioDisplayFrame();
					Controller.audioDisplayFrame=audioDisplayFrame;
					audioDisplayFrame.setVisible(true);
					Controller.audioSelection.dispose();
				}
			});
			btnAudio4.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 25));
		}
		
		panel.add(btnAudio4);
		contentPane.setLayout(null);
		contentPane.add(button);
		contentPane.add(txtpnAudioRound);
		contentPane.add(separator);
		contentPane.add(panel);
	}

}
