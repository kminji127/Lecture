import java.awt.*;

public class GridTestCal extends Frame {

	Panel p1, p2;
	TextField tf;
	
	public GridTestCal() {
		super("GridTestCal");
		setLayout(new BorderLayout());
		setSize(500, 400);
		setVisible(true);
		
		p1 = new Panel();
		tf = new TextField(50);
		p1.add(tf);
		
		p2 = new Panel();
		p2.setLayout(new GridLayout(5, 4));
		p2.add(new Button("C"));
		p2.add(new Button("/"));
		p2.add(new Button("X"));
		p2.add(new Button("DEL"));
		p2.add(new Button("7"));
		p2.add(new Button("8"));
		p2.add(new Button("9"));
		p2.add(new Button("-"));
		p2.add(new Button("4"));
		p2.add(new Button("5"));
		p2.add(new Button("6"));
		p2.add(new Button("+"));
		p2.add(new Button("1"));
		p2.add(new Button("2"));
		p2.add(new Button("3"));
		p2.add(new Button("()"));
		p2.add(new Button("0"));
		p2.add(new Button("."));
		p2.add(new Button("+/-"));
		p2.add(new Button("="));
		
		add(p1, "North");
		add(p2);
	}

}
