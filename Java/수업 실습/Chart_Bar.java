import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Chart_Bar extends JFrame {

	public Chart_Bar() {
		setSize(500, 500);
		setTitle("김민지: 막대 차트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new BarPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("결과 보기");
//		button.addActionListener(new DrawingActionListener)
		setVisible(true);
	}
	
	class BarPanel extends JPanel {
	    int a, b, c;
	    
	    public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			// 텍스트
			g2.drawString("나의 성적표 그래프", 20, 50);
			g2.drawString("빨강: 객체지향프로그래밍", 20, 70);
			g2.drawString("노랑: 선형대수학", 20, 90);
			g2.drawString("파랑: 통계수학", 20, 110);
			
			// 그래프
			g.clearRect(0, 0, getWidth(), getHeight());
	    }
	    
	}
	
	public static void main(String[] args) {
		new Chart_Bar();
	}

}
