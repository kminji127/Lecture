import java.awt.*;
import javax.swing.*;

public class JLabelTest {

	JFrame jf;
	JLabel label1, label2;
	ImageIcon logo;
	
	public JLabelTest(String msg) {
		jf = new JFrame(msg);
		jf.setVisible(true);
		jf.setSize(600, 600);
		jf.setTitle("Image Label Test: 김민지");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.getContentPane().setBackground(Color.CYAN);
		
		label1 = new JLabel("Sookmyung Women's University");
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		logo = new ImageIcon("sym01_m.gif");
		label2 = new JLabel("눈송이 로고", logo, JLabel.LEFT);
		
		jf.getContentPane().add("North", label1);
		jf.getContentPane().add("Center", label2);

	}

}
