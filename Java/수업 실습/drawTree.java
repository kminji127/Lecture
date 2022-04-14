import javax.swing.*;
import java.awt.*;

public class drawTree extends JFrame {

	public drawTree(String msg) {
		super(msg);
		add(new DrawTreePanel());
		setSize(600, 500);
		setVisible(true);
	}
	
	public class DrawTreePanel extends JPanel {
		public DrawTreePanel() {	
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			drawTree(g, 300, 400, -90, 8);
		}
		
		private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
			if(depth == 0) return;
			int x2 = x1 + (int)(Math.cos(Math.toRadians(angle)) * depth * 10.0);
			int y2 = y1 + (int)(Math.sin(Math.toRadians(angle)) * depth * 10.0);
			g.drawLine(x1, y1, x2, y2); // 가지 그리기
			drawTree(g, x2, y2, angle-20, depth-1); // 왼쪽 가지에 drawTree 반복 수행
			drawTree(g, x2, y2, angle+20, depth-1); // 오른쪽 가지에 drawTree 반복 수행
		}
	}

	public static void main(String[] args) {
		new drawTree("김민지: DrawTree");
	}

}
