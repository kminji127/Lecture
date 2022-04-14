import java.awt.*;

public class ButtonLabel1 {

	// 클래스 내의 전역변수, 클래스 내의 모든 함수에서 접근 가능
	Button b;
	Label l;
	
	public ButtonLabel1() {
		Frame f = new Frame("Button Label Test 21"); // 프레임 생성
		f.setSize(500, 500); // 사이즈 설정
		f.setVisible(true); // 프레임을 보여주게 설정
		f.setLayout(new FlowLayout()); // 레이아웃 설정(FlowLayout)
		
		b = new Button("OK"); // 버튼 생성		
		l = new Label("Kim Minji"); // 라벨 생성
		 
		f.add(b); // 프레임(f)에 버튼(b) 추가
		f.add(l);  // 프레임(f)에 라벨(l) 추가
	}

}
