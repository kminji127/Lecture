import java.awt.*;

public class GridTestOne extends Frame {

	public GridTestOne() {
		super("GridTestOne");
		setLayout(new GridLayout(2, 3));
		setSize(300, 200);
		setVisible(true);
		
		add(new Button("1"));
		add(new Button("2"));
		add(new Button("3"));
		add(new Button("4"));
		add(new Button("5"));
		add(new Button("6"));
	}

}
