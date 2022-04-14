import java.awt.BorderLayout;

import javax.swing.*;

public class InnerFrameTest2 {

	JFrame jf;
	JDesktopPane desktop;
	JInternalFrame inframe1, inframe2;
	JButton ok, icon;
	JPanel jp;
	ImageIcon logo;
	
	public InnerFrameTest2(String msg) {
		jf = new JFrame(msg);
		jf.setSize(500, 500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		
		desktop = new JDesktopPane();
		
		inframe1 = new JInternalFrame("Inner Frame 1", true, true, false, false);
		inframe1.setSize(200, 200);
		inframe1.setVisible(true);
		ok = new JButton("OK");
		inframe1.getContentPane().add(ok, BorderLayout.SOUTH);
		
		inframe2 = new JInternalFrame("Inner Frame 2", true, true, false, false);
		inframe2.setSize(300, 300);
		inframe2.setVisible(true);
		jp = new JPanel();
		logo = new ImageIcon("sm_logo.gif");
		icon = new JButton(logo);
		jp.add(icon);
		inframe2.getContentPane().add(jp, BorderLayout.SOUTH);
		
		desktop.add(inframe1);
		desktop.add(inframe2);
		jf.getContentPane().add(desktop, BorderLayout.CENTER);
	}

}
