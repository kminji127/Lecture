import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ShapesFill extends JFrame {

	public ShapesFill() {
		setSize(600, 140);
		setTitle("김민지: Java 2D Shapes Fill Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new ShapesFillPanel();
		add(panel);
		setVisible(true);
	}
	
	class ShapesFillPanel extends JPanel {

		public ShapesFillPanel() {
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			// 부드러운 테두리 효과
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3));
			GradientPaint gp = new GradientPaint(0, 0, Color.WHITE, 0, 100, Color.RED);
			
			// 사각형
			g2.setPaint(Color.RED);
			g2.fill(new Rectangle2D.Float(10, 10, 70, 80));
			
			// 둥근 사각형
			g2.setPaint(gp);
			g2.fill(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20));
			
			// 타원
			g2.setPaint(Color.RED);
			g2.fill(new Ellipse2D.Float(210, 10, 80, 80));
			
			// 원호: Arc2D.OPEN
			g2.setPaint(gp);
			g2.fill(new Arc2D.Float(310, 10, 80, 80, 45, 225, Arc2D.OPEN));
			
			// 원호: Arc2D.CHORD
			g2.setPaint(Color.RED);
			g2.fill(new Arc2D.Float(410, 10, 80, 80, 45, 225, Arc2D.CHORD));
			
			// 원호: Arc2D.PIE
			g2.setPaint(gp);
			g2.fill(new Arc2D.Float(510, 10, 80, 80, 45, 225, Arc2D.PIE));
		}
	}

	public static void main(String[] args) {
		ShapesFill sh = new ShapesFill();
	}

}
