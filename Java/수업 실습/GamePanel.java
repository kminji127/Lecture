import java.awt.*;
import java.util.*;
import javax.swing.*;

// 패널
public class GamePanel extends JPanel {
	Image backImg, food;
	int width, height;
	boolean isDead = false; // 음식 생존 여부
	
	// 음식 이미지를 저장하기 위한 ArrayList
	ArrayList<Food> foodList = new ArrayList<Food>();
	
	public GamePanel() {
		width = getWidth();
		height = getHeight();
			
		backImg = Toolkit.getDefaultToolkit().getImage("Images/backimg.png");
		food = Toolkit.getDefaultToolkit().getImage("Images/sushi3.png");
	}
		
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(width == 0 || height == 0) {
			width = getWidth();
			height = getHeight();
			backImg = backImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		}
			
		g.drawImage(backImg, 0, 0, this); // 배경 출력
			
		for(Food f : foodList) { // 음식 출력
			g.drawImage(f.img, f.x-f.w, f.y-f.h, this);
		}
	}
		
	void makeFood() { // 음식 생성
		if(width == 0 || height == 0) return;
		int n = new Random().nextInt(20);
		if(n == 0) {
			foodList.add(new Food(food, width, height)); // 랜덤으로 음식 생성
		}
	}
	
	void move() { // 음식 내려감
		for (int i=foodList.size()-1; i>=0; i--) {
			Food f = foodList.get(i);
			if(f.isDead)
				foodList.remove(i); // 음식이 끝까지 내려가면 ArrayList에서 제거
		}
	}

}
