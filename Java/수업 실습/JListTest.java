import java.awt.FlowLayout;
import javax.swing.*;

public class JListTest {

	JFrame jf;
	String items[] = {"apple", "grape", "melon", "orange", "banana", "pear"};
	JList fruits;
	JScrollPane sp;
	
	public JListTest() {
		jf = new JFrame("JList Test");
		jf.setSize(200, 200);
		jf.setVisible(true);
		jf.getContentPane().setLayout(new FlowLayout());
		
		fruits = new JList(items);
		fruits.setVisibleRowCount(4);
		
		sp = new JScrollPane(fruits);
		
		jf.getContentPane().add(sp);
		
	}
	

	public static void main(String[] args) {
		new JListTest();
	}
}
