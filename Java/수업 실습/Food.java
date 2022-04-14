import java.awt.Image;
import java.util.Random;

// 음식 관련 클래스
public class Food {
	Image img; // 음식 이미지 매개변수
	int x, y; // 이미지 좌표
	int w, h; // 이미지 절반 폭
	int width, height;
	boolean isDead = false; // 음식 생존 여부
	
	public Food(Image foodImg, int width, int height) {
		this.width = width;
		this.height = height;
		
		img = foodImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		w = 25; // 이미지 절반 폭
		h = 25; // 이미지 절반 높이
		
		x = new Random().nextInt(width - 50); // x 좌표는 0부터 550까지 랜덤 (음식 크기가 50인 것을 고려)
		y = -h; // y 좌표는 처음에는 패널 밖(위)로 설정
	}
	
	void move() { // 음식 떨어지는 효과
		y += 5; // y 좌표를 5씩 증가
		if(y > height+h) { // y 좌표가 패널 높이만큼 커지면 (땅으로 떨어지면)
			isDead = true; // 음식을 없애도록 설정
		}
	}
}
