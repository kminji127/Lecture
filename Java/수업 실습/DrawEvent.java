import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawEvent extends JPanel {
	int startX, startY, w, h;
	JPanel jp;
	
	public void DrawEvent() {
		
	}
	
	void drawPanel() {
		addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				w = Math.abs(startX - e.getX());
				h = Math.abs(startY - e.getY());
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				w = Math.abs(startX - e.getX());
				h = Math.abs(startY - e.getY());
				repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(startX, startY, w, h);
		drawPanel();
	}

}
