import java.awt.*;

public class LoginUI {

	// UI 관련 변수 선언
	Label llg, lpw, lnote, press;
	TextField login, passwd;
	TextArea note;
	Button ok;
	
	// Panel 선언
	Panel p1, p2, p3;
	
	// Lab
	public LoginUI() {
		Frame f = new Frame("Lab : LoginUI Test1");
		f.setLayout(new FlowLayout());
		f.setSize(500, 500);
		f.setVisible(true);
		
		// UI 관련 컴포넌트 선언
		llg = new Label("Login");
		login = new TextField(50);
		
		lpw = new Label("Password");
		passwd = new TextField(50);
		passwd.setEchoChar('*');
		
		lnote = new Label("주석");
		note = new TextArea("주석을 다세요", 20, 50);
		
		// 생성된 컴포넌트 추가
		f.add(llg);
		f.add(login);

		f.add(lpw);
		f.add(passwd);
		
		f.add(lnote);
		f.add(note);
	}
	
	
	// HW
	public LoginUI(String msg) {
		Frame f = new Frame(msg);
		f.setLayout(new GridLayout(3, 1)); // 3행 1열
		f.setSize(600, 200);
		f.setVisible(true);
		
		// Panel 선언 및 추가
		p1 = new Panel(); // 1행: llg, login
		p2 = new Panel(); // 2행: lpw, passwd
		p3 = new Panel(); // 3행: press, ok
		
		f.add(p1);
		f.add(p2);
		f.add(p3);

		// UI 관련 컴포넌트 선언
		llg = new Label("Login");
		login = new TextField(50);
		
		lpw = new Label("Password");
		passwd = new TextField(50);
		passwd.setEchoChar('*');
		
		press = new Label("Press");
		ok = new Button("OK");
		
		// Panel 안에 생성된 컴포넌트 추가
		p1.add(llg);
		p1.add(login);

		p2.add(lpw);
		p2.add(passwd);
		
		p3.add(press);
		p3.add(ok);
	}

}
