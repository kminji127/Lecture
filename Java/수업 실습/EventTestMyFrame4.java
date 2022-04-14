import javax.swing.*;
import java.awt.event.*;

public class EventTestMyFrame4 extends JFrame {
	private JButton button;
	private JLabel label;
	JPanel panel;
	
	public EventTestMyFrame4() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("김민지: Event Programming Style 4");
		
		panel = new JPanel();
		button = new JButton("Button");
		label = new JLabel("Please Click the Button");
		button.addActionListener(new EventTestMyListener(label));

		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new EventTestMyFrame4();
	}

}
