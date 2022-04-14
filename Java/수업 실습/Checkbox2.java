import java.awt.*;

public class Checkbox2 extends Frame {
	// 단일 상속이므로 다른 클래스를 상속받을 수 없음
	
	Checkbox one, two, three;
	
	public Checkbox2(String msg) {
		super(msg);
		setLayout(new FlowLayout());
		setSize(300, 200);
		setVisible(true);
		
		one = new Checkbox("One");
		two = new Checkbox("Two");
		three = new Checkbox("Three");
		
		add(one);
		add(two);
		add(three);
	}
	
	public Checkbox2() {
		super("CheckboxTest2");
		setLayout(new FlowLayout());
		setSize(300, 200);
		setVisible(true);
		
		one = new Checkbox("One");
		two = new Checkbox("Two");
		three = new Checkbox("Three");
		
		add(one);
		add(two);
		add(three);
	}

}
