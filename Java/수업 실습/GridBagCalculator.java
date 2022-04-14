import java.awt.*;

public class GridBagCalculator extends Frame {

	Panel p1, p2;
	TextField tf;
	String[] msg = {"C", "CE", "1/x", "DEL", "%", "/", "x", "-", "7", "8", "9", "+", "4", "5", "6", "()", "1", "2", "3", "+/-", "0", ".", "="};
	Button[] btn = new Button[msg.length];
	
	// GridBagLayout 객체 생성
	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints constraint = new GridBagConstraints();
	
	public GridBagCalculator() {
		super("GridBagCalculator"); // 프레임 제목
		setLayout(new BorderLayout()); // 레이아웃
		setSize(400, 500); // 프레임 사이즈
		setVisible(true); // 보여주게 설정
		
		// 텍스트 패널
		p1 = new Panel();
		p1.setLayout(new GridLayout(2, 1)); // 간격 넓히기
		tf = new TextField(30);
		tf.setFont(new Font("SansSerif", Font.BOLD, 30)); // 폰트 설정
		p1.add(tf);
		
		// 계산기 패널
		p2 = new Panel();
		p2.setLayout(gridbag);
		constraint.fill = GridBagConstraints.BOTH; // 가로, 세로 채우기
		constraint.weightx = 1.0;
		constraint.weighty = 1.0;
		
		// 버튼
		for(int i=0; i<btn.length; i++) {
			btn[i] = new Button(msg[i]);
			btn[i].setFont(new Font("SansSerif", Font.BOLD, 30));
		}
		
		// 버튼 크기, 위치 설정
		make(btn[0], 0, 0, 1, 1);
		make(btn[1], 1, 0, 1, 1);
		make(btn[2], 2, 0, 1, 1);
		make(btn[3], 3, 0, 1, 1);
		make(btn[4], 0, 1, 1, 1);
		make(btn[5], 1, 1, 1, 1);
		make(btn[6], 2, 1, 1, 1);
		make(btn[7], 3, 1, 1, 1);
		make(btn[8], 0, 2, 1, 1);
		make(btn[9], 1, 2, 1, 1);
		make(btn[10], 2, 2, 1, 1);
		make(btn[11], 3, 2, 1, 1);
		make(btn[12], 0, 3, 1, 1);
		make(btn[13], 1, 3, 1, 1);
		make(btn[14], 2, 3, 1, 1);
		make(btn[15], 3, 3, 1, 1);
		make(btn[16], 0, 4, 1, 1);
		make(btn[17], 1, 4, 1, 1);
		make(btn[18], 2, 4, 1, 1);
		make(btn[19], 3, 4, 1, 1);
		make(btn[20], 0, 5, 1, 1);
		make(btn[21], 1, 5, 1, 1);
		make(btn[22], 2, 5, 2, 1); // "=" 버튼만 너비를 2로
		
		// 버튼 추가
		for (int i=0; i<btn.length; i++) {
			p2.add(btn[i]);
		}
		
		// 프레임에 Panel 추가
		add(p1, "North");
		add(p2);
	}
	
	public void make(Component c, int x, int y, int w, int h) {
		constraint.gridx = x; // 위치
		constraint.gridy = y; // 위치
		constraint.gridwidth = w; // 너비
		constraint.gridheight = h; // 높이
		gridbag.setConstraints(c, constraint);
	}

}
