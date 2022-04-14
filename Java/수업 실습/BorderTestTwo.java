import java.awt.*;

public class BorderTestTwo extends Frame {
	Panel panel;
	
	public BorderTestTwo() {
		super("BorderTestTwo");
		setLayout(new BorderLayout(5, 5));
		setSize(300, 200);
		setVisible(true);
		
		add(new Label("Hello World!!!!!!!!!", Label.CENTER), BorderLayout.NORTH);
		add(new TextArea("Center", 5, 20), BorderLayout.CENTER);
		
		panel = new Panel();
		panel.setLayout(new FlowLayout());
		panel.add(new Button("OK"));
		panel.add(new Button("CANCEL"));
		add(panel, BorderLayout.SOUTH);
	}

}
