import javax.swing.JFrame;

public class JCheckBoxTextMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("CheckBoxDemo:김민지");
		JCheckboxTest panel = new JCheckboxTest();
		panel.setOpaque(true);
		
		frame.add(panel);
		frame.setSize(500, 200);
		frame.setVisible(true);
	}

}
