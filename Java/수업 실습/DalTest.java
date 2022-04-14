import java.awt.*;
import javax.swing.*;

public class DalTest extends JFrame {
	Dal a, b, c, d;
	ImageIcon back, img1, img2, img3, img4;
	
	public DalTest() {
		super("김민지: Thread Test");
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		a = new Dal(this, 30, 215);
		b = new Dal(this, 30, 255);
		c = new Dal(this, 30, 300);
		d = new Dal(this, 30, 350);
		
		// 각 객체의 스레드 메소드(run) 호출
		a.start();
		b.start();
		c.start();
		d.start();
	}
	
	public void paint(Graphics g) {
		back = new ImageIcon("backimg.jpg");
		img1 = new ImageIcon("1.png");
		img2 = new ImageIcon("2.png");
		img3 = new ImageIcon("3.png");
		img4 = new ImageIcon("4.png");
		
		g.drawImage(back.getImage(), 0, 30, null);
		g.drawImage(img1.getImage(), a.x, a.y, null);
		g.drawImage(img2.getImage(), b.x, b.y, null);
		g.drawImage(img3.getImage(), c.x, c.y, null);
		g.drawImage(img4.getImage(), d.x, d.y, null);
	}

}
