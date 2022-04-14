import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorTest extends JFrame {

	public ColorTest() {
		setTitle("김민지: Color Test");
		JPanel panel = new ColorPanel();
		add(panel);
		setSize(240, 300);
		setVisible(true);
	}

	class ColorPanel extends JPanel implements ActionListener {
		JButton button;
		Color color = new Color(0, 0, 0);
		
		public ColorPanel() {
			setLayout(new BorderLayout());
			button = new JButton("색상 변경");
			button.addActionListener(this);
			add(button, BorderLayout.SOUTH);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(color);
			g.fillRect(10, 10, 210, 220);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			color = new Color((int)(Math.random() * 255.0), 
							  (int)(Math.random() * 255.0), 
							  (int)(Math.random() * 255.0));
			repaint();
		}
	}
	
	public static void main(String[] args) {
		ColorTest c = new ColorTest();
	}

}
