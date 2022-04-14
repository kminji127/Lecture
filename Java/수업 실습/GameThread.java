
// 스레드
public class GameThread extends Thread {
	GamePanel panel = new GamePanel();
	
	@Override
	public void run() {
		while(true) {
			panel.makeFood(); // panel의 음식 생성 메소드 실행
			panel.move(); // 음식 내려가는 메소드 실행
			panel.repaint(); // 화면 갱신
			
			// 스레드 잠시 정지
			try {
				sleep(40);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
