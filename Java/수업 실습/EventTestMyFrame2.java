import java.awt.event.*;
import javax.swing.*;

public class EventTestMyFrame2 extends JFrame {
	private JButton button;
	private JLabel label;
	JPanel panel;

	public EventTestMyFrame2() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("김민지: Event Programming Style 2");
		
		panel = new JPanel();
		button = new JButton("Button");
		label = new JLabel("Please Click the Button");
		button.addActionListener(new MyListener());
		
		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}

	// inner class, named MyListener
	private class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button) {
				label.setText("Clicked the Button");
			}
		}
	}
	
	public static void main(String[] args) {
		new EventTestMyFrame2();
	}

}
