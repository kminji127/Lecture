import java.awt.*;

public class ListTest21 extends Frame {

	List list1, list2;
	
	public ListTest21(String msg) {
		super(msg);
		setLayout(new FlowLayout());
		setSize(300, 200);
		setVisible(true);
		
		// 단일 선택 리스트
		list1 = new List(6, false);
		list1.add("One");
		list1.add("Two");
		list1.add("Three");
		list1.add("Four");
		list1.add("Five");
		list1.add("Six");
		
		// 다중 선택 리스트
		list2 = new List(6, true);
		list2.add("One");
		list2.add("Two");
		list2.add("Three");
		list2.add("Four");
		list2.add("Five");
		list2.add("Six");
		
		add(list1);
		add(list2);
	}

}
