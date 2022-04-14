import java.awt.*;
import javax.swing.*;

public class JTableTest2 extends JFrame {

	JTable table;
	JScrollPane sp;
	
	public JTableTest2(String msg) {
		super(msg);
		setSize(400, 200);
		setVisible(true);
		
		String[] columnName = {"Name", "Age", "E-Mail"};
		@SuppressWarnings("deprecation")
		Object[][] data	= {
				{"Kim", new Integer(20), "kim@sookmyung.ac.kr"},
				{"Yoon", new Integer(30), "yoon@gmail.com"},
				{"Park", new Integer(40), "park@naver.com"},
				{"Lee", new Integer(50), "lee@sm.ac.kr"}
		};
		
		table = new JTable(data, columnName);
		sp = new JScrollPane(table);
		getContentPane().add(sp, "Center");
	}

}
