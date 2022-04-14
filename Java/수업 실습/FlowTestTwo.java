import java.awt.*;

public class FlowTestTwo extends Frame {

	public FlowTestTwo() {
		super("FlowTestTwo");
		setSize(500, 200);
		setVisible(true);
		setLayout(new FlowLayout());
		
		add(new Button("1"));
		add(new Button("2"));
		add(new TextField("3", 3)); // 3 columns
		add(new Button("4"));
		add(new List(5, true)); // 5 rows
		add(new Button("6"));
		add(new Button("7")).setVisible(false);;
		add(new Label("8"));
		add(new Button("9"));
		add(new TextArea("10", 3, 4)); // 3 rows, 4 columns
		add(new Button("11"));
	}

}
