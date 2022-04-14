import java.awt.*;

public class ButtonTest {
	
	ButtonTest() {
		Frame f = new Frame("Button Test"); // 프레임 생성
		f.setSize(400, 600); // 사이즈 설정
		f.setVisible(true); // 프레임을 보여주게 설정
		
		Button b = new Button("OK"); // 버튼 생성
		f.add(b); // 프레임(f)에 버튼(b) 추가
	}

}
