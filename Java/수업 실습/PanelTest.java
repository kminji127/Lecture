import java.awt.*;

public class PanelTest extends Frame {

	Panel p;
	Label l;
	Button b;
	
	public PanelTest(String msg) {
		super(msg);
		setLayout(null);
		setSize(300, 300);
		setVisible(true);
		
		p = new Panel();
		p.setSize(100, 100);
		p.setBackground(Color.yellow);
		p.setLocation(50, 100);
		
		l = new Label("Panel");
		p.add(l);
		
		b = new Button("OK");
		p.add(b);
		
		add(p);
	}

}
