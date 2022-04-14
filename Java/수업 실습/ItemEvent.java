import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ItemEvent extends Frame implements ItemListener, ActionListener {

	Frame f;
	Panel p1, p2;
	Checkbox one, two;
	Checkbox male, female;
	CheckboxGroup cbg;
	Button exit;
	
	public ItemEvent(String msg) {
		f = new JFrame(msg);
		
		p1 = new Panel();
		one = new Checkbox("One");
		one.addItemListener(this);
		two = new Checkbox("Two");
		two.addItemListener(this);
		p1.add(one);
		p1.add(two);
		f.add("North", p1);
		
		p2 = new Panel();
		cbg = new CheckboxGroup();
		male = new Checkbox("남자", cbg, true);
		male.addItemListener(this);
		female = new Checkbox("여자", cbg, false);
		female.addItemListener(this);
		p2.add(male);
		p2.add(female);
		f.add("South", p2);
		
		exit = new Button("Exit");
		exit.addActionListener(this);
		f.add("East", exit);
		
		f.setSize(300, 200);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		f.setVisible(false);
		f.dispose();
		System.exit(0);
	}
	
	@Override
	public void itemStateChanged(java.awt.event.ItemEvent e) {
		Object o = e.getSource();
		
		if(o == one) {
			System.out.println(e.getItem());
		}
		else if(o == two) {
			if(e.getStateChange() == e.SELECTED) {
				System.out.println("two is selected");
			} else {
				System.out.println("two is deselected");
			}
		}
		else if(o == male) {
			System.out.println("남자 - selected");
		} else if(o == female) {
			System.out.println("여자 - selected");
		}	
	}

	public static void main(String[] args) {
		new ItemEvent("김민지: Item Event in Check");
	}

}
