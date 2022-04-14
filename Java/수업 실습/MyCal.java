import java.awt.*;
import java.awt.event.*;

public class MyCal extends Frame implements ActionListener {
	Panel p1, p2;
	TextField tf;
	String[] msg = {"C", "CE", "1/x", "DEL", "%", "/", "x", "-", "7", "8", "9", "+", "4", "5", "6", "()", "1", "2", "3", "+/-", "0", ".", "="};
	Button[] btn = new Button[msg.length];
	double n1, n2;
	double result; // 연산 결과
	String func = ""; // 기능 연산자
	String nInput = ""; // 마지막에 누른 연산자 저장
	boolean state = false; // 결과 입력 후 다음 숫자 입력 시 화면에 나온 결과 값 지움
	
	// GridBagLayout 객체 생성
	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints constraint = new GridBagConstraints();
	
	public MyCal(String title) {
		super(title);
		setLayout(new BorderLayout()); // 레이아웃
		setSize(400, 500); // 프레임 사이즈
		setVisible(true); // 보여주게 설정
		
		// 연산 결과창 패널
		p1 = new Panel();
		p1.setLayout(new GridLayout(2, 1)); // 간격 넓히기
		tf = new TextField("0", 30);
		tf.setFont(new Font("SansSerif", Font.BOLD, 30)); // 폰트 설정
		p1.add(tf);
		
		// 버튼 패널
		p2 = new Panel();
		p2.setLayout(gridbag);
		constraint.fill = GridBagConstraints.BOTH; // 가로, 세로 채우기
		constraint.weightx = 1.0;
		constraint.weighty = 1.0;
		
		// 버튼
		for(int i=0; i<btn.length; i++) {
			btn[i] = new Button(msg[i]);
			btn[i].setFont(new Font("SansSerif", Font.BOLD, 30));
			btn[i].addActionListener(this); // Event Listener 설정
		}
		
		// 버튼 크기, 위치 설정
		make(btn[0], 0, 0, 1, 1); // C
		make(btn[1], 1, 0, 1, 1); // CE
		make(btn[2], 2, 0, 1, 1); // 1/x
		make(btn[3], 3, 0, 1, 1); // DEL
		make(btn[4], 0, 1, 1, 1); // %
		make(btn[5], 1, 1, 1, 1); // /
		make(btn[6], 2, 1, 1, 1); // x
		make(btn[7], 3, 1, 1, 1); // -
		make(btn[8], 0, 2, 1, 1); // 7
		make(btn[9], 1, 2, 1, 1); // 8
		make(btn[10], 2, 2, 1, 1); // 9
		make(btn[11], 3, 2, 1, 1); // +
		make(btn[12], 0, 3, 1, 1); // 4
		make(btn[13], 1, 3, 1, 1); // 5
		make(btn[14], 2, 3, 1, 1); // 6
		make(btn[15], 3, 3, 1, 1); // ()
		make(btn[16], 0, 4, 1, 1); // 1
		make(btn[17], 1, 4, 1, 1); // 2
		make(btn[18], 2, 4, 1, 1); // 3
		make(btn[19], 3, 4, 1, 1); // +/x
		make(btn[20], 0, 5, 1, 1); // 0
		make(btn[21], 1, 5, 1, 1); // .
		make(btn[22], 2, 5, 2, 1); // "=" 버튼만 너비를 2로
		
		// 버튼 추가
		for (int i=0; i<btn.length; i++) {
			p2.add(btn[i]);
		}
		
		// 프레임에 Panel 추가
		add(p1, "North");
		add(p2);
	}
	
	// 버튼 생성 함수
	public void make(Component c, int x, int y, int w, int h) {
		constraint.gridx = x; // 위치
		constraint.gridy = y; // 위치
		constraint.gridwidth = w; // 너비
		constraint.gridheight = h; // 높이
		gridbag.setConstraints(c, constraint);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand(); // 이벤트 발생시킨 객체의 문자열을 input에 저장
		if (input.equals("+")) {
			n1 = n2;
			func = "+";
			nInput = "";
		} else if (input.equals("-")) {
			n1 = n2;
			func = "-";
			nInput = "";
		} else if (input.equals("x")) {
			n1 = n2;
			func = "x";
			nInput = "";
		} else if (input.equals("/")) {
			n1 = n2;
			func = "/";
			nInput = "";
		} else if (input.equals("%")) {
			n1 = n2;
			func = "%";
			nInput = "";
			result = n1 / 100;
			tf.setText(String.valueOf(result));
		} else if (input.equals("C")) {
			n1 = 0;
			n2 = 0;
			nInput = "";
			tf.setText("0");
		} else if (input.equals("DEL")) {
			setBackSpace(getBackSpace().substring(0, getBackSpace().length()-1));
			if(getBackSpace().length() < 1) {
				nInput = "";
				n2 = 0;
				n1 = 0;
				tf.setText("0");
			}
		} else if (input.equals("=")) {
			if (func.equals("+")) {
				result = n1 + n2;
				tf.setText(String.valueOf(result));
				state = true; // 결과 입력 후 다음 숫자 입력 시 화면에 나온 결과 값 지움
			} else if (func.equals("-")) {
				result = n1 - n2;
				tf.setText(String.valueOf(result));
				state = true;
			} else if (func.equals("x")) {
				result = n1 * n2;
				tf.setText(String.valueOf(result));
				state = true;
			} else if (func.equals("/")) {
				result = n1 / n2;
				tf.setText(String.valueOf(result));
				state = true;
			}
		} else {
			if(state) {
				tf.setText("0");
				state = false;
				n1 = 0;
				n2 = 0;
				nInput = "";
			}
		}
		
		nInput += e.getActionCommand();
		tf.setText(nInput);
		n2 = Double.parseDouble(nInput);
	}
	
	public void setBackSpace(String b) {
		tf.setText(b);
	}
	
	public String getBackSpace() {
		return tf.getText();
	}
	
	public static void main(String[] args) {
		new MyCal("김민지: HW Chap 7");
	}
}
