import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GradientTest extends JFrame {

	public GradientTest() {
		setSize(300, 300);
		setTitle("김민지: Java 2D Gradient Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new GradientPanel();
		add(panel);
		setVisible(true);
	}
	
	class GradientPanel extends JPanel {
		
		Ellipse2D.Double circle;
		Rectangle2D.Double rect;
		GradientPaint gradient;

		public GradientPanel() {
			circle = new Ellipse2D.Double(10, 10, 200, 200);
			rect = new Rectangle2D.Double(10, 10, 200, 200);
			gradient = new GradientPaint(10, 10, Color.red, 200, 200, Color.yellow, true);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(gradient);
			g2.fill(circle);
			g2.draw(rect);
		}
	}

	public static void main(String[] args) {
		new GradientTest();
	}

}
