import java.awt.*;

public class LoginUIWithGL extends Frame {

	Label llg, lpw, press;
	TextField login, passwd;
	Button ok;
	Panel p1, p2, p3;
	
	public LoginUIWithGL(String msg) {
		super(msg);
		setLayout(new GridLayout(3, 1)); // 3행 1열
		setSize(600, 200);
		setVisible(true);
		
		p1 = new Panel(); // 1행: llg, login
		p2 = new Panel(); // 2행: lpw, passwd
		p3 = new Panel(); // 3행: press, ok

		llg = new Label("Login");
		login = new TextField(50);
		p1.add(llg);
		p1.add(login);
		
		lpw = new Label("Password");
		passwd = new TextField(50);
		passwd.setEchoChar('*');
		p2.add(lpw);
		p2.add(passwd);
		
		press = new Label("Press");
		ok = new Button("OK");
		p3.add(press);
		p3.add(ok);
		
		add(p1);
		add(p2);
		add(p3);
	}

}
