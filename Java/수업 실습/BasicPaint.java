import java.awt.*;
import javax.swing.*;

public class BasicPaint {

	public BasicPaint(String msg) {
		JFrame f = new JFrame(msg);
		f.add(new MyPanel()); // Panel to draw
		f.setSize(300, 200);
		f.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public MyPanel() {
			setBorder(BorderFactory.createLineBorder(Color.black));
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRect(50, 50, 50, 50);
			g.drawOval(200, 50, 50, 50);
		}
	}
	
	public static void main(String[] args) {
		new BasicPaint("Java 2D & Graphic");
	}
}
