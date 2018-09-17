package frames;

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
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class TopicFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopicFrame frame = new TopicFrame();
					Controller.tframe=frame;
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
	public TopicFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnTopic = new JTextPane();
		txtpnTopic.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DisplayQuestion displayquestion=new DisplayQuestion();
				Controller.display=displayquestion;
				displayquestion.setVisible(true);
				Controller.tframe.dispose();
			}
		});
		StyledDocument doc = txtpnTopic.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		txtpnTopic.setFocusTraversalKeysEnabled(false);
		txtpnTopic.setFocusCycleRoot(false);
		txtpnTopic.setEditable(false);
		txtpnTopic.setBackground(Color.BLACK);
		txtpnTopic.setForeground(Color.LIGHT_GRAY);
		txtpnTopic.setFont(new Font("Maiandra GD", Font.PLAIN, 99));
		txtpnTopic.setText("TOPIC");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(334, Short.MAX_VALUE)
					.addComponent(txtpnTopic, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
					.addGap(324))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(375)
					.addComponent(txtpnTopic, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(474, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		if(Controller.color=="violet")
		{
			contentPane.setBackground(new Color(148, 0, 211));
			txtpnTopic.setText("ENTERTAINMENT");
		}
		else if(Controller.color=="indigo")
		{
			contentPane.setBackground(new Color(75, 0, 130));
			txtpnTopic.setText("WORLD WATCH");
		}
		else if(Controller.color=="blue")
		{
			contentPane.setBackground(Color.BLUE);
			txtpnTopic.setText("LANGUAGE LITERATURE");
		}
		else if(Controller.color=="green")
		{
			contentPane.setBackground(Color.GREEN);
			txtpnTopic.setText("WORLD OF PLANTS & ANIMALS");
			gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(334)
							.addComponent(txtpnTopic, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(324, Short.MAX_VALUE))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(375)
							.addComponent(txtpnTopic, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(331, Short.MAX_VALUE))
				);
		}
		else if(Controller.color=="yellow")
		{
			contentPane.setBackground(Color.YELLOW);
			txtpnTopic.setText("SPORTS");
		}
		else if(Controller.color=="orange")
		{
			contentPane.setBackground(Color.ORANGE);
			txtpnTopic.setText("SCIENCE & TECHNOLOGY");
		}
		else if(Controller.color=="red")
		{
			contentPane.setBackground(Color.RED);
			txtpnTopic.setText("HISTORY");
		}
		else if(Controller.color=="white")
		{
			contentPane.setBackground(Color.WHITE);
			txtpnTopic.setText("OUR SCHOOL");
		}
		
		
	}
}
/*GroupLayout gl_contentPane = new GroupLayout(contentPane);
gl_contentPane.setHorizontalGroup(
	gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			.addContainerGap(334, Short.MAX_VALUE)
			.addComponent(txtpnTopic, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
			.addGap(324))
);
gl_contentPane.setVerticalGroup(
	gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
			.addGap(375)
			.addComponent(txtpnTopic, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(474, Short.MAX_VALUE))
);*/