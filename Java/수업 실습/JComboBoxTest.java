import java.awt.FlowLayout;
import javax.swing.*;

public class JComboBoxTest {

	JFrame jf;
	String items[] = {"apple", "grape", "melon", "orange", "banana", "pear"};
	JComboBox fruits;
	
	public JComboBoxTest() {
		jf = new JFrame("JComboBox Test");
		jf.setSize(200, 200);
		jf.setVisible(true);
		jf.getContentPane().setLayout(new FlowLayout());
		
		fruits = new JComboBox(items);
		jf.getContentPane().add(fruits);
		
	}

	public static void main(String[] args) {
		new JComboBoxTest();
	}

}
