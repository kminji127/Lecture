import java.awt.*;
import javax.swing.*;

public class JButtonTest {

	JFrame jf;
	JButton plus, minus, mux, divide;
	ImageIcon iplus, iminus, imux, idivide;
	
	public JButtonTest(String msg) {
		jf = new JFrame(msg);
		jf.getContentPane().setLayout(new GridLayout(2,2));
		jf.setVisible(true);
		jf.setSize(400, 480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iplus = new ImageIcon("plus.png");
		iminus = new ImageIcon("minus.png");
		imux = new ImageIcon("mux.png");
		idivide = new ImageIcon("divide.png");
		
		plus = new JButton(iplus);
		minus = new JButton(iminus);
		mux = new JButton(imux);
		divide = new JButton(idivide);
		
		jf.getContentPane().add(plus);
		jf.getContentPane().add(minus);
		jf.getContentPane().add(mux);
		jf.getContentPane().add(divide);
	}

}
