import java.awt.*;
import javax.swing.*;

public class JTextComponentTest {

	// UI 관련 변수 선언
	JFrame jf;
	JPanel p1, p2, p3;
	JLabel jllg, jlpw, press;
	JTextField login;
	JPasswordField password;
	JTextArea note;
	JButton ok;

	public JTextComponentTest() {
		jf = new JFrame("Login UI with JTextComponents:김민지");
		jf.setSize(400, 400);
		jf.setVisible(true);
		jf.getContentPane().setLayout(new BorderLayout());
		
		// 1번째 패널: login, password
		p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 2));
		jllg = new JLabel("Login");
		login = new JTextField(20);
		p1.add(jllg);
		p1.add(login);
		
		jlpw = new JLabel("Password");
		password = new JPasswordField(20);
		password.setEchoChar('*');
		p1.add(jlpw);
		p1.add(password);
		
		// 2번째 패널: note
		p2 = new JPanel();
		note = new JTextArea("Enter for Your Opinion", 13, 10);
		p2.add(note);
		
		// 3번째 패널: Press, OK 버튼
		p3 = new JPanel();
		press = new JLabel("Press");
		ok = new JButton("OK");
		p3.add(press);
		p3.add(ok);
		
		// 패널 추가
		jf.getContentPane().add(p1, "North");
		jf.getContentPane().add(p2, "Center");
		jf.getContentPane().add(p3, "South");
		
	}

	public static void main(String[] args) {
		JTextComponentTest ui = new JTextComponentTest();
	}

}
