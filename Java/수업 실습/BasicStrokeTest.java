import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class BasicStrokeTest extends JFrame {

	public BasicStrokeTest() {
		setSize(300, 300);
		setTitle("김민지: Java 2D BasicStroke Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new BasicStrokePanel();
		add(panel);
		setVisible(true);
	}
	
	class BasicStrokePanel extends JPanel {
		
		Ellipse2D.Double circle;
		Rectangle2D.Double rect;

		public BasicStrokePanel() {
			circle = new Ellipse2D.Double(10, 10, 220, 220);
			rect = new Rectangle2D.Double(10, 10, 220, 220);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setStroke(new BasicStroke(2));
			g2.draw(rect);
			
			float[] dashPattern = {30, 10, 10, 10};
			g2.setStroke(new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0));
			g2.draw(circle);
		}
	}

	public static void main(String[] args) {
		new BasicStrokeTest();
	}

}
