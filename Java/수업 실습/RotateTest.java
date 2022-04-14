import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RotateTest extends JFrame {

	public RotateTest() {
		setSize(330, 330);
		setTitle("김민지: Java 2D Rotate Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new RotatePanel();
		add(panel);
		setVisible(true);
	}
	
	class RotatePanel extends JPanel {
		
		Rectangle2D.Double rect;

		public RotatePanel() {
			rect = new Rectangle2D.Double(10, 10, 150, 50);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			g2.draw(rect);
			g2.translate(80, 30); // 위치 변경
			g2.rotate(Math.PI/8.0); // 회전
			g2.draw(rect);
			
			g2.translate(150, 150);
			for(int i=0; i<4; i++) {
				g2.rotate(Math.PI/2.0);
				g2.drawString("Hello World", 0, 0);
			}
		}
	}

	public static void main(String[] args) {
		new RotateTest();
	}

}
