import javax.swing.*;
import java.awt.*;

public class SnowManFace {

	public SnowManFace(String msg) {
		JFrame f = new JFrame(msg);
		f.add(new SnowManPanel());
		f.setSize(300, 300);
		f.setVisible(true);
	}
	
	class SnowManPanel extends JPanel {
		public SnowManPanel() {
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.pink);
			g.fillOval(20, 30, 200, 200); // 타원형 얼굴
			g.setColor(Color.black);
			g.drawArc(60, 80, 50, 50, 180, -180); // 왼쪽 눈
			g.drawArc(140, 80, 50, 50, 180, -180); // 오른쪽 눈
			g.drawArc(70, 130, 100, 70, 180, 180); // 입
		}
	}

	public static void main(String[] args) {
		SnowManFace smf = new SnowManFace("김민지: Smile Face");
	}

}
