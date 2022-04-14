import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Chart_Circle extends JFrame {

	public Chart_Circle() {
		setSize(400, 500);
		setTitle("김민지: 원형 차트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new CirclePanel();
		add(panel);
		setVisible(true);
	}
	
	class CirclePanel extends JPanel {
		
		public CirclePanel() {
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			// 텍스트
			g2.drawString("나의 성적 분포", 20, 50);
			g2.drawString("빨강: A", 20, 70);
			g2.drawString("노랑: B", 20, 90);
			g2.drawString("파랑: C", 20, 110);
			
			// 부드러운 테두리 효과
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setStroke(new BasicStroke(3));
			
			// 원호: Arc2D.OPEN
			g2.setPaint(Color.RED);
			g2.fill(new Arc2D.Float(100, 150, 200, 200, 0, 170, Arc2D.PIE));
			
			g2.setPaint(Color.YELLOW);
			g2.fill(new Arc2D.Float(100, 150, 200, 200, 170, 130, Arc2D.PIE));
			
			g2.setPaint(Color.BLUE);
			g2.fill(new Arc2D.Float(100, 150, 200, 200, 300, 60, Arc2D.PIE));
		}
	
	}

	public static void main(String[] args) {
		new Chart_Circle();
	}

}
