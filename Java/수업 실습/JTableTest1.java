import java.awt.*;
import javax.swing.*;

public class JTableTest1 extends JFrame {

	JTable table;
	JScrollPane sp;
	
	public JTableTest1(String msg) {
		super(msg);
		setSize(400, 400);
		setVisible(true);
		
		String columnName[] = {"이름", "전화번호", "E-Mail"};
		String data[][]	= {
				{"김민지", "02-111-1111", "it19@sookmyung.ac.kr"},
				{"김눈송", "010-9999-8888", "adgb@gmail.com"},
				{"이눈송", "010-7777-6666", "oop@naver.com"}
		};

		table = new JTable(data, columnName);
		sp = new JScrollPane(table);
		
		getContentPane().add(sp, BorderLayout.CENTER);
	}

}
