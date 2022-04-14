import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class KeyTypeEvent extends JPanel {
	BufferedImage img = null;
	int img_x = 1;
	int img_y = 1;
	
	public KeyTypeEvent() {
		try {
			img = ImageIO.read(new File("car.jpeg"));
		} catch (IOException e) {
			System.out.println("No Image");
			System.exit(1);
		}
		
		// JPanel에 대한 KeyEvent
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode(); // key의 방향
				switch(keycode) {
				case KeyEvent.VK_UP   : img_y -= 10; break;
				case KeyEvent.VK_DOWN : img_y += 10; break;
				case KeyEvent.VK_LEFT : img_x -= 10; break;
				case KeyEvent.VK_RIGHT: img_x += 10; break;
				}
				repaint();
			}
			public void keyReleased(KeyEvent arg0) { }
			public void keyTyped(KeyEvent arg0) { }
		});
		
		this.requestFocus(); // Key Event를 받을 컴포넌트를 강제로 설정
		setFocusable(true); // Key Event의 Focus를 받을 수 있도록 설정
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}

}
