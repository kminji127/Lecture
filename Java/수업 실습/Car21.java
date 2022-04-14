import javax.swing.*;
import java.awt.*;

public class Car21 extends JButton implements Runnable {
	public static int rank1; // 등수
	private int rank2; // 자신의 등수
	private ImageIcon name;
	public JPanel lane = new JPanel();
	private int x, y; // 차 위치 값
	
	public Car21(ImageIcon name, int x, int y) {
		lane.setLayout(null);
		int r, g, b;
		r = (int)(Math.random()*256);
		g = (int)(Math.random()*256);
		b = (int)(Math.random()*256);
		
		lane.setBackground(new Color(r,g,b));
		this.name = name;
		this.setIcon(name);
		this.setBackground(Color.pink);
		this.setOpaque(false);
		this.setBounds(x, y, 130, 200);
		lane.add(this);
	}
	
	public void run() {
		// 차가 달리는 부분
		for(int i=0; i<1024; i++) {
			x = i;
			// 움직이는 부분
			this.setBounds(x, y, 130, 200);
			// 차마다 서로 다른 임의의 interval을 가짐
			try {
				Thread.sleep((int)(Math.random() * 20));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 경기 종료
		rank1++;
		rank2 = rank1;
		(lane.getGraphics()).drawString(rank2 + "Rank", 800, 30);
	}

}
