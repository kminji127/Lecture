import java.awt.*;

public class DialogTest extends Frame {

	Dialog d;
	
	public DialogTest(String title) {
		super(title);
		setSize(300, 200);
		setVisible(true);
		
		d = new Dialog(this, "Dialog", false);
		d.add("Center", new Label("This is a Dialog!"));
		d.add("South", new Button("OK"));
		d.pack();
//		add(d); // error
		d.setVisible(true);
	}

}
