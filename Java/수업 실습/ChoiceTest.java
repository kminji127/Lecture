import java.awt.*;

public class ChoiceTest extends Frame{
	
	Choice choice;
	
	public ChoiceTest(String msg) {
		super(msg);
		setLayout(new FlowLayout());
		setSize(300, 200);
		setVisible(true);
		
		choice = new Choice();
		choice.add("One");
		choice.add("Two");
		choice.add("Three");
		choice.add("Four");
		choice.add("Five");
		choice.add("Six");
		
		add(choice);
	}

}
