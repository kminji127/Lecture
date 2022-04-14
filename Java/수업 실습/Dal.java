import javax.swing.JFrame;

public class Dal extends Thread {
	int x, y;
	int speed;
	JFrame app;

	public Dal(JFrame _app, int w, int h) {
		app = _app;
		x = w;
		y = h;
	}
	
	public void run() {
		while(x < 600) { // 특정 위치에 가면 멈추도록 설정
			speed = (int)(Math.random() * 50);
			x += speed;
			app.repaint(); // paint() 호출
			try {
				sleep(speed * 100); // 랜덤 속도
			} catch(Exception ex) { }
		}
	}

}
