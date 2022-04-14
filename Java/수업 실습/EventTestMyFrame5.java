import javax.swing.*;

public class EventTestMyFrame5 extends JFrame {
	private JButton button;
	private JLabel label;
	JPanel panel;
	
	public EventTestMyFrame5() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("김민지: Event Programming Style 5");
		
		panel = new JPanel();
		button = new JButton("Button");
		label = new JLabel("Please Click the Button");
		// Lambda Expression (가장 간단한 방법)
		button.addActionListener(e -> {
			label.setText("Clicked the Button");
		});

		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new EventTestMyFrame5();
	}

}
