import java.awt.*; // AWT 패키지 불러오기

public class LabelTest {

	public static void main(String[] args) {
		Frame f = new Frame("Label test"); // 프레임 생성
		f.setSize(400, 200); // 사이즈 설정
		f.setVisible(true); // 프레임을 보여주게 설정
		
		Label lb = new Label("IT Dept: KIM"); // 라벨 생성
		f.add(lb); // 프레임(f)에 라벨(lb) 추가

	}

}
