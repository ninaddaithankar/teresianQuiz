package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import frames.TopicFrame;

import java.awt.Frame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class SpectrumRoundFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpectrumRoundFrame frame = new SpectrumRoundFrame();
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
	public SpectrumRoundFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.CYAN);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnSpectrumRound = new JTextPane();
		txtpnSpectrumRound.setBounds(777, 73, 360, 74);
		txtpnSpectrumRound.setFont(new Font("Segoe UI", Font.BOLD, 45));
		txtpnSpectrumRound.setBackground(Color.BLACK);
		txtpnSpectrumRound.setForeground(Color.LIGHT_GRAY);
		txtpnSpectrumRound.setEnabled(true);
		txtpnSpectrumRound.setEditable(false);
		txtpnSpectrumRound.setText("Spectrum Round");
		
		JSeparator separator = new JSeparator();
		separator.setBounds(696, 179, 532, 2);
		
		JPanel panel = new JPanel();
		panel.setBounds(267, 284, 1390, 626);
		
		JButton button = new JButton("<<-Back");
		button.setBounds(104, 73, 145, 60);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Controller.spectrumRound.dispose();
			}
		});
		button.setFont(new Font("Segoe UI", Font.BOLD, 25));
		panel.setLayout(new GridLayout(2, 4, 0, 0));
		panel.setBackground(Color.BLACK);
		
		JButton btnViolet = new JButton("Violet");
		btnViolet.setForeground(Color.WHITE);
		btnViolet.setFont(new Font("Segoe UI", Font.ITALIC, 35));
		if(Controller.violet.equals("selected"))
		{
			btnViolet.setBackground(Color.DARK_GRAY);
			btnViolet.setText("Already Selected!");
			btnViolet.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnViolet.setForeground(Color.WHITE);
		}
		else 
		{
			btnViolet.setBackground(new Color(148, 0, 211));
			btnViolet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					Controller.color="violet";
					TopicFrame topicframe=new TopicFrame();
					Controller.tframe=topicframe;
					topicframe.setVisible(true);
					Controller.spectrumRound.dispose();
				}
			});
		}
		panel.add(btnViolet);
		
		JButton btnIndigo = new JButton("Indigo");
		btnIndigo.setFont(new Font("Segoe UI", Font.ITALIC, 35));
		if(Controller.indigo.equals("selected"))
		{
			btnIndigo.setBackground(Color.DARK_GRAY);
			btnIndigo.setText("Already Selected!");
			btnIndigo.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnIndigo.setForeground(Color.WHITE);
		}
		else 
		{
			btnIndigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Controller.color="indigo";
					TopicFrame topicframe=new TopicFrame();
					Controller.tframe=topicframe;
					topicframe.setVisible(true);
					Controller.spectrumRound.dispose();
				}
			});
			btnIndigo.setForeground(Color.WHITE);
			btnIndigo.setFont(new Font("Segoe UI",Font.ITALIC, 35));
			btnIndigo.setBackground(new Color(75, 0, 130));
		}
		panel.add(btnIndigo);
		
		JButton btnBlue = new JButton("Blue");
		btnBlue.setFont(new Font("Segoe UI", Font.BOLD, 35));
		if(Controller.blue.equals("selected"))
		{
			btnBlue.setBackground(Color.DARK_GRAY);
			btnBlue.setText("Already Selected!");
			btnBlue.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnBlue.setForeground(Color.WHITE);
		}
		else
		{
			btnBlue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Controller.color="blue";
					TopicFrame topicframe=new TopicFrame();
					Controller.tframe=topicframe;
					topicframe.setVisible(true);
					Controller.spectrumRound.dispose();
				}
			});
			btnBlue.setForeground(Color.WHITE);
			btnBlue.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnBlue.setBackground(new Color(0, 0, 255));
		}
		panel.add(btnBlue);
		
		JButton btnGreen = new JButton("Green");
		btnGreen.setFont(new Font("Segoe UI", Font.BOLD, 35));
		if(Controller.green.equals("selected"))
		{
			btnGreen.setBackground(Color.DARK_GRAY);
			btnGreen.setText("Already Selected!");
			btnGreen.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnGreen.setForeground(Color.WHITE);
		}
		else
		{btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.color="green";
				TopicFrame topicframe=new TopicFrame();
				Controller.tframe=topicframe;
				topicframe.setVisible(true);
				Controller.spectrumRound.dispose();
			}
		});
		btnGreen.setFont(new Font("Segoe UI", Font.ITALIC, 35));
		btnGreen.setBackground(Color.GREEN);
			
		}
		
		panel.add(btnGreen);
		
		JButton btnWhite = new JButton("White");
		btnWhite.setFont(new Font("Segoe UI", Font.BOLD, 35));
		if(Controller.white.equals("selected"))
		{
			btnWhite.setBackground(Color.DARK_GRAY);
			btnWhite.setText("Already Selected!");
			btnWhite.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnWhite.setForeground(Color.WHITE);
		}
		else
		{
			btnWhite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Controller.color="white";
					TopicFrame topicframe=new TopicFrame();
					Controller.tframe=topicframe;
					topicframe.setVisible(true);
					Controller.spectrumRound.dispose();
				}
			});
			btnWhite.setFont(new Font("Segoe UI", Font.ITALIC, 35));
		}
		
		panel.add(btnWhite);
		
		JButton btnRed = new JButton("Red");
		btnRed.setFont(new Font("Segoe UI", Font.BOLD, 35));
		if(Controller.red.equals("selected"))
		{
			btnRed.setBackground(Color.DARK_GRAY);
			btnRed.setText("Already Selected!");
			btnRed.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnRed.setForeground(Color.WHITE);
		}
		else
		{
			btnRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Controller.color="red";
					TopicFrame topicframe=new TopicFrame();
					Controller.tframe=topicframe;
					topicframe.setVisible(true);
					Controller.spectrumRound.dispose();
				}
			});
			btnRed.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnRed.setBackground(Color.RED);
		}
		
		panel.add(btnRed);
		
		JButton btnOrange = new JButton("Orange");
		btnOrange.setFont(new Font("Segoe UI", Font.BOLD, 35));
		if(Controller.orange.equals("selected"))
		{
			btnOrange.setBackground(Color.DARK_GRAY);
			btnOrange.setText("Already Selected!");
			btnOrange.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnOrange.setForeground(Color.WHITE);
		}
		else
		{
			btnOrange.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Controller.color="orange";
					TopicFrame topicframe=new TopicFrame();
					Controller.tframe=topicframe;
					topicframe.setVisible(true);
					Controller.spectrumRound.dispose();
				}
			});
			btnOrange.setFont(new Font("Segoe UI",Font.ITALIC, 35));
			btnOrange.setBackground(new Color(255, 165, 0));
		}
		
		panel.add(btnOrange);
		
		JButton btnYellow = new JButton("Yellow");
		btnYellow.setFont(new Font("Segoe UI", Font.BOLD, 35));
		if(Controller.yellow.equals("selected"))
		{
			btnYellow.setBackground(Color.DARK_GRAY);
			btnYellow.setText("Already Selected!");
			btnYellow.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnYellow.setForeground(Color.WHITE);
		}
		else
		{
			btnYellow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Controller.color="yellow";
					TopicFrame topicframe=new TopicFrame();
					Controller.tframe=topicframe;
					topicframe.setVisible(true);
					Controller.spectrumRound.dispose();
				}
			});
			btnYellow.setFont(new Font("Segoe UI", Font.ITALIC, 35));
			btnYellow.setBackground(new Color(255, 255, 0));
		}
		
		panel.add(btnYellow);
		contentPane.setLayout(null);
		contentPane.add(button);
		contentPane.add(txtpnSpectrumRound);
		contentPane.add(separator);
		contentPane.add(panel);
	}
}
