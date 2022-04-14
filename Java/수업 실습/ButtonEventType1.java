import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonEventType1 {
	JFrame jf;
	JPanel panel;
	JButton btn1;
	JButton btn2;
	
	MyListener listener = new MyListener();

	public ButtonEventType1(String msg) {
		jf = new JFrame(msg);
		jf.setSize(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		btn1 = new JButton("노란색");
		btn1.addActionListener(listener);
		panel.add(btn1);
		
		btn2 = new JButton("핑크색");
		btn2.addActionListener(listener);
		panel.add(btn2);
		
		jf.add(panel);
		jf.setVisible(true);
	}
	
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn1) {
				panel.setBackground(Color.yellow);
			} else if(e.getSource() == btn2) {
				panel.setBackground(Color.pink);
			}
		}
	}

	public static void main(String[] args) {
		new ButtonEventType1("김민지: Button Event Type1");
	}

}
