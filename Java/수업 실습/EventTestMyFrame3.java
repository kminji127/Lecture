import java.awt.event.*;
import javax.swing.*;

public class EventTestMyFrame3 extends JFrame {
	private JButton button;
	private JLabel label;
	JPanel panel;

	public EventTestMyFrame3() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("김민지: Event Programming Style 3");
		
		panel = new JPanel();
		button = new JButton("Button");
		label = new JLabel("Please Click the Button");
		
		// Implements for event
		button.addActionListener(new ActionListener() {
			// 무명 Class
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button) {
					label.setText("Clicked the Button");
				}
			}
		});
		
		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new EventTestMyFrame3();
	}

}
