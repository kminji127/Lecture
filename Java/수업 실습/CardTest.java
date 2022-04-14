import java.awt.*;
import java.awt.event.*;

public class CardTest {

	Frame f;
	CardLayout card;
	Panel p1, p2, p3, p4, p5;
	Label l1, l2, l3, l4, l5;
	
	public CardTest() {
		f = new Frame("SimpleCard");
		f.setSize(300, 200);
		f.setVisible(true);
		card = new CardLayout();
		f.setLayout(card);
		
		p1 = new Panel();
		p1.setBackground(Color.yellow);
		l1 = new Label("First Panel");
		p1.add(l1);
		
		p2 = new Panel();
		p2.setBackground(Color.green);
		l2 = new Label("Second Panel");
		p2.add(l2);
		
		p3 = new Panel();
		p3.setBackground(Color.magenta);
		l3 = new Label("Third Panel");
		p3.add(l3);
		
		p4 = new Panel();
		p4.setBackground(Color.white);
		l4 = new Label("Fourth Panel");
		p4.add(l4);
		
		p5 = new Panel();
		p5.setBackground(Color.cyan);
		l5 = new Label("Fifth Panel");
		p5.add(l5);
		
		MouseHandler handler = new MouseHandler();
		p1.addMouseListener(handler);
		p2.addMouseListener(handler);
		p3.addMouseListener(handler);
		p4.addMouseListener(handler);
		p5.addMouseListener(handler);
		
		f.add("First", p1);
		f.add("Second", p2);
		f.add("Third", p3);
		f.add("Fourth", p4);
		f.add("Fifth", p5);
		
		card.show(f, "First");
	}
	
	// 마우스를 클릭하면 다음으로 넘어가는 클래스
	public class MouseHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			card.next(f); // card.next(this);
		}
	}

}
