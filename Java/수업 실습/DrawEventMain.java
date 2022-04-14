import javax.swing.*;

public class DrawEventMain {
	JFrame jf;
	
	public DrawEventMain(String msg) {
		jf = new JFrame(msg);
		jf.setSize(500, 500);
		jf.add(new DrawEvent());
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new DrawEventMain("김민지: Test Mouse Move Event Type");

	}

}
