package frames;

import java.awt.CardLayout;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Controller; 

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setFocusTraversalPolicyProvider(true);
		setTitle("TIME Quiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 580);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel cards=new JPanel(new CardLayout());
		Controller.cards=cards;
		
		//The Welcome Screen
		JPanel welcomeScreen=new JPanel();
		Controller.welcomeScreen=welcomeScreen;
		cards.add(welcomeScreen,"WelcomeScreen");
		
		//The Round Selection Screen
		JPanel roundSelection=new JPanel();
		Controller.roundSelectionScreen=roundSelection;
		cards.add(roundSelection,"RoundSelectionScreen");
		
		//The Standard Selection Screen for Round 1
		JPanel standardSelection=new JPanel();
		Controller.standardSelectionScreen=standardSelection;
		cards.add(standardSelection,"StandardSelectionScreen");
		StandardSelectionScreen.showStandardSelectionScreen();
	
		
		CardLayout cardLayout=(CardLayout)cards.getLayout();
		cardLayout.show(cards,"WelcomeScreen");
		WelcomeScreen.showWelcomeScreen();
		
		getContentPane().add(cards);
	}
}
