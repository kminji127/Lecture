import java.awt.event.*;
import javax.swing.*;

public class EventTestMyFrame1 extends JFrame implements ActionListener {
	JPanel panel;
	JButton button;
	JLabel label;
	
	public EventTestMyFrame1() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("김민지: Event Programming Style 1");
		
		panel = new JPanel();
		button = new JButton("Click Button");
		label = new JLabel("버튼을 눌러주세요.");
		
		// 가장 일반적인 경우
		button.addActionListener(this);
		
		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}
	
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == button) {
			label.setText("Clicked the Button");
		}
	}

	public static void main(String[] args) {
		new EventTestMyFrame1();
	}

}
