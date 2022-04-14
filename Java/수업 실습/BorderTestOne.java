import java.awt.*;

public class BorderTestOne {

	public BorderTestOne() {
		Frame f = new Frame("Border Test One");
		f.setLayout(new BorderLayout(5, 5));
		f.setSize(300, 200);
		f.setVisible(true);
		
		f.add("North", new Button("North"));
		f.add("Center", new Button("Center"));
		f.add("South", new Button("South"));
		f.add("West", new Button("West"));
		f.add("East", new Button("East"));
	}

}
