import java.awt.*;
import javax.swing.*;

// 메인 클래스
public class FallingFoodMain {
	JFrame jf;
	GamePanel panel;
	GameThread thread;
	
	public FallingFoodMain(String msg) {
		jf = new JFrame(msg);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(600, 650);
		
		panel = new GamePanel();
		jf.add(panel, BorderLayout.CENTER); // 게임 패널 추가

		thread = new GameThread();
		thread.start(); // 스레드 시작
		
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new FallingFoodMain("김민지: Thread HW(하늘에서 음식이 내린다면)");
	}
}
