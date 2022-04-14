import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MoreShapes extends JFrame {

	public MoreShapes() {
		setSize(600, 150);
		setTitle("김민지: Java 2D Shapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MyShapePanel();
		add(panel);
		setVisible(true);
	}

	class MyShapePanel extends JPanel {
		ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		
		public MyShapePanel() {
			Shape s;
			
			// 사각형
			s = new Rectangle2D.Float(10, 10, 70, 80);
			shapeArray.add(s);
			
			// 둥근 사각형
			s = new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20);
			shapeArray.add(s);
			
			// 타원
			s = new Ellipse2D.Float(210, 10, 80, 80);
			shapeArray.add(s);
			
			// 원호: Arc2D.OPEN
			s = new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN);
			shapeArray.add(s);
			
			// 원호: Arc2D.CHORD
			s = new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD);
			shapeArray.add(s);
			
			// 원호: Arc2D.PIE
			s = new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE);
			shapeArray.add(s);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			// 부드러운 테두리 효과
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3));
			for (Shape s : shapeArray)
				g2.draw(s);
		}
	}
	
	public static void main(String[] args) {
		MoreShapes msl = new MoreShapes();
	}

}
