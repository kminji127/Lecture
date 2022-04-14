import java.awt.*;

public class ButtonLabel21Frame extends Frame {

	// 클래스 내의 전역변수, 클래스 내의 모든 함수에서 접근 가능
	Button b;
	Label l;
	
	public ButtonLabel21Frame() {
		super("Button Label Test 21 Frame"); // Frame을 상속받아 프레임 생성
		// 자기 자신이 frame이 되었기 때문에 참조변수 필요없음
		
		setSize(500, 500); // 사이즈 설정
		setVisible(true); // 프레임을 보여주게 설정
		setLayout(new FlowLayout()); // 레이아웃 설정(FlowLayout)
		
		b = new Button("OK"); // 버튼 생성		
		l = new Label("Kim Minji"); // 라벨 생성
		 
		add(b); // 프레임에 버튼(b) 추가
		add(l);  // 프레임에 라벨(l) 추가
	}
	
	// 생성자 오버로딩
	public ButtonLabel21Frame(String msg) {
		super(msg); // 입력받은 값이 Frame 이름이 됨
		
		setSize(500, 500);
		setVisible(true);
		setLayout(new FlowLayout());
		
		b = new Button("OK");	
		l = new Label("Kim Minji");
		 
		add(b);
		add(l);
	}
	
}
