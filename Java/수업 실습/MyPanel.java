import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

	public MyPanel() {
		// 필요한 초기화 기능 설정
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void PaintComponent(Graphics g) {
		super.paintComponent(g);
		// 여기에 그림 그리는 코드 구현
		g.drawRect(50, 50, 50, 50);
		g.drawOval(200, 50, 50, 50);
	}

}
