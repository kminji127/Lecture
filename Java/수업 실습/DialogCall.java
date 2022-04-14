import javax.swing.*;
import java.awt.event.*;

public class DialogCall extends JFrame {

	MyDialog dialog;
	JButton btn;
	
	public DialogCall() {
		super("JDialog Example:김민지");
		btn = new JButton("Show Dialog");
		dialog = new MyDialog(this, "Test Dialog");
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		
		getContentPane().add(btn);
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DialogCall();
	}

}
