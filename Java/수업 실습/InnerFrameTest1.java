import java.awt.*;
import javax.swing.*;

public class InnerFrameTest1 {

	JFrame jf;
	JDesktopPane desktop;
	JInternalFrame inframe;
	JButton ok;
	
	public InnerFrameTest1(String msg) {
		jf = new JFrame(msg);
		jf.setSize(300, 200);
		jf.setVisible(true);
		
		desktop = new JDesktopPane();
		inframe = new JInternalFrame("Inner Frame 1", true, true, false, false);
		inframe.setSize(200, 100);
		inframe.setVisible(true);
		ok = new JButton("OK");
		inframe.getContentPane().add(ok, BorderLayout.SOUTH);
		desktop.add(inframe);
		
		jf.getContentPane().add(desktop, BorderLayout.CENTER);
		
	}

}
