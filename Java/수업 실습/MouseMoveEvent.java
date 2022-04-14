import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class MouseMoveEvent extends JPanel {
	BufferedImage img = null;
	int img_x = 0;
	int img_y = 0;
	
	public MouseMoveEvent() {
		try {
			img = ImageIO.read(new File("car.jpeg"));
		} catch (IOException e) {
			System.out.println("No Image");
			System.exit(1);
		}
		
		// JPanel에 대한 Event 등록
		addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				repaint();
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}


}
