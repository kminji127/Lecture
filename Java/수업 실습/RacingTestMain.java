import java.awt.*;

public class RacingTestMain {

	public static void main(String[] args) {
		// 이벤트 대기
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RacingTest frame = new RacingTest();
					frame.setVisible(true);	
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
