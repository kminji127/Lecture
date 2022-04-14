import java.awt.*;

public class GridTestTwo extends Frame {

	List list;
	Panel panel;
	
	public GridTestTwo() {
		super("GridTestTwo");
		setLayout(new GridLayout(3, 2));
		setSize(500, 400);
		setVisible(true);
		
		add(new Button("1"));
		
		add(new TextField("2", 10)); // 10 columns
		
		add(new TextArea("3", 5, 10)); // 5 rows, 10 columns
		
		list = new List(5, false);
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		list.add("seven");
		list.add("eight");
		add(list);
		
		panel = new Panel();
		panel.setLayout(new BorderLayout());
		panel.add("North", new Button("north"));
		panel.add("East", new Button("east"));
		add(panel);
		
		add(new Label("6"));
	}

}
