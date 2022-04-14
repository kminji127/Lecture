import java.awt.*;

public class Checkbox1 {

	Checkbox one, two, three;
	
	public Checkbox1(String msg) {
		Frame f = new Frame(msg);
		f.setLayout(new FlowLayout());
		f.setSize(300, 200);
		f.setVisible(true);
		
		one = new Checkbox("One");
		two = new Checkbox("Two");
		three = new Checkbox("Three");
		
		f.add(one);
		f.add(two);
		f.add(three);
	}
	
	public Checkbox1() {
		Frame f = new Frame("CheckboxTest1");
		f.setLayout(new FlowLayout());
		f.setSize(300, 200);
		f.setVisible(true);
		
		one = new Checkbox("One");
		two = new Checkbox("Two");
		three = new Checkbox("Three");
		
		f.add(one);
		f.add(two);
		f.add(three);
	}

}
