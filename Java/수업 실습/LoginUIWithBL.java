import java.awt.*;

public class LoginUIWithBL extends Frame {
	
	// UI 관련 변수 선언
	Label llg, lpw, press;
	TextField login, passwd;
	Button ok;
	
	// Panel 선언
	Panel p1, p2, p3;
	
	public LoginUIWithBL(String msg) {
		super(msg);
		setLayout(new BorderLayout());
		setSize(300, 200);
		setVisible(true);
		
		// Panel 선언 및 추가
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		add(p1, "North");
		add(p2, "Center");
		add(p3, "South");

		// UI 관련 컴포넌트 선언
		llg = new Label("Login");
		login = new TextField(20);
		
		lpw = new Label("Password");
		passwd = new TextField(20);
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
