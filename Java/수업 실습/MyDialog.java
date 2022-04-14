import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyDialog extends JDialog {
	JTextField tf;
	JButton ok;
	
	public MyDialog(JFrame frame, String title) {
		super(frame, title);
		setSize(250, 200);
		setLayout(new FlowLayout());
		
		tf = new JTextField(20); // Dialog Contents
		ok = new JButton("OK");
		add(tf);
		add(ok);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
