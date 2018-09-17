package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RapidFireTeamSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RapidFireTeamSelection frame = new RapidFireTeamSelection();
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
	public RapidFireTeamSelection() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("<<-Back");
		button.setBounds(104, 83, 152, 74);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Controller.roundSelectionScreen.setVisible(true);
				Controller.rapidFireTeamSelection.dispose();
			}
		});
		button.setFont(new Font("Segoe UI", Font.BOLD, 28));
		contentPane.add(button);
		
		JTextPane txtpnSelectTheTeam = new JTextPane();
		txtpnSelectTheTeam.setFont(new Font("Microsoft YaHei", Font.BOLD, 55));
		txtpnSelectTheTeam.setForeground(Color.LIGHT_GRAY);
		txtpnSelectTheTeam.setBackground(Color.BLACK);
		txtpnSelectTheTeam.setEditable(false);
		txtpnSelectTheTeam.setText("Select the TEAM to ask questions for :");
		txtpnSelectTheTeam.setBounds(430, 77, 1054, 91);
		contentPane.add(txtpnSelectTheTeam);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(583, 213, 748, 2);
		contentPane.add(separator);
		
		JButton btnTopaz = new JButton("Topaz");
		btnTopaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Controller.group="one";
				RapidFire rapidFireFrame=new RapidFire();
				Controller.rapidFire=rapidFireFrame;
				rapidFireFrame.setVisible(true);
			}
		});
		btnTopaz.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 45));
		btnTopaz.setBounds(336, 314, 477, 256);
		contentPane.add(btnTopaz);
		
		JButton btnIndicolite = new JButton("Indicolite");
		btnIndicolite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Controller.group="two";
				RapidFire rapidFireFrame=new RapidFire();
				Controller.rapidFire=rapidFireFrame;
				rapidFireFrame.setVisible(true);
			}
		});
		btnIndicolite.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 45));
		btnIndicolite.setBounds(1094, 314, 477, 256);
		contentPane.add(btnIndicolite);
		
		JButton btnMeloPearl = new JButton("Melo Pearl");
		btnMeloPearl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Controller.group="three";
				RapidFire rapidFireFrame=new RapidFire();
				Controller.rapidFire=rapidFireFrame;
				rapidFireFrame.setVisible(true);
			}
		});
		btnMeloPearl.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 45));
		btnMeloPearl.setBounds(336, 676, 477, 256);
		contentPane.add(btnMeloPearl);
		
		JButton btnEmerald = new JButton("Emerald");
		btnEmerald.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Controller.group="four";
				RapidFire rapidFireFrame=new RapidFire();
				Controller.rapidFire=rapidFireFrame;
				rapidFireFrame.setVisible(true);
			}
		});
		btnEmerald.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 45));
		btnEmerald.setBounds(1094, 676, 477, 256);
		contentPane.add(btnEmerald);
	}
}
