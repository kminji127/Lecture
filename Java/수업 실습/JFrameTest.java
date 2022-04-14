import javax.swing.*;

public class JFrameTest {

	public JFrameTest(String msg) {
		JFrame jf = new JFrame(msg);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 200);
		jf.setVisible(true);
	}

}
