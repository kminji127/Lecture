import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JButtonImageLabelTest implements ActionListener {

	JFrame jf;
	JPanel panel;
	JLabel label;
	JButton button;
	ImageIcon icon;
	
	public JButtonImageLabelTest(String msg) {
		jf = new JFrame(msg);
		jf.setTitle("JButton Event Test:김민지");
		jf.setVisible(true);
		jf.setSize(700, 700);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		label = new JLabel("Click JButton to see Image");
		button = new JButton("See Image");
		icon = new ImageIcon("icon.gif");
		
		button.setIcon(icon);
		button.addActionListener(this);
		
		panel.add(label);
		panel.add(button);
		
		jf.add(panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon cat = new ImageIcon("cat.jpg");
		label.setIcon(cat);
		label.setText("Lovely Cat");
		button.setText("행운을 주는 고양이");
	}
}
