import javax.swing.*;
import java.awt.*;

public class paintJPanelEx {
	
	public paintJPanelEx() {
		JFrame f = new JFrame();
		f.setTitle("김민지:Line Shapes");
        MyShapePanel panel = new MyShapePanel();
        f.add(panel);
        
        f.setSize(300,300);
        f.setVisible(true);
	}

	class MyShapePanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);   // JPanel의 paintComponent() 호출
             
            g.setColor(Color.black); // 검은색 선택
			
			int[] xp = new int[] {10, 50, 100, 200, 10, 10};
			int [] yp = new int[] {10, 10, 100, 200, 200, 10};
			
			g.drawPolyline(xp, yp, 6);
			g.drawLine(50, 100, 70, 100);
		}
	}
	
	public static void main(String[] args) {
		new paintJPanelEx();
	}

}
