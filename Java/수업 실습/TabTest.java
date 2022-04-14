import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TabTest implements ItemListener, ActionListener  {

	JFrame jf;
	JTabbedPane tabpane;
	JPanel one, two, three, four;
	ImageIcon logo, cat;
	JLabel label1, label2;
	JButton btn;
	
	// 과일 Checkbox 관련 변수
	JCheckBox[] buttons = new JCheckBox[3];
	String[] fruits = {"apple", "grape", "pear"};
	JLabel[] pictureLabel = new JLabel[3];
	ImageIcon[] icon = new ImageIcon[3];
	
	// 주문 RadioButton 관련 변수
	JRadioButton small, medium, large;
	JLabel text;
	JPanel topPanel, sizePanel, resultPanel;
	
	public TabTest(String msg) {
		jf = new JFrame(msg);
		jf.setSize(600, 600);
		jf.setVisible(true);
		
		tabpane = new JTabbedPane();
		
		one = new JPanel();
		two = new JPanel();
		three = new JPanel();
		four = new JPanel();
		
		one.setBackground(Color.red);
		two.setBackground(Color.green);
		three.setBackground(Color.blue);
		four.setBackground(Color.orange);
		
		// one
		logo = new ImageIcon("sm_logo.gif");
		label1 = new JLabel("SMU Logo", logo, JLabel.RIGHT);
		label1.setFont(new Font("굴림", Font.BOLD, 30));
		one.add(label1);
		
		// two
		cat = new ImageIcon("cat.jpg");
		btn = new JButton("CAT♥", cat);
		two.add(btn);
		
		// three
		three.setLayout(new GridLayout(0, 4));
		for (int i = 0; i < 3; i++) {
			buttons[i] = new JCheckBox(fruits[i]);
			buttons[i].addItemListener(this);
			pictureLabel[i] = new JLabel(fruits[i] + ".jpeg");
			icon[i] = new ImageIcon(fruits[i] + ".jpeg");
		}
		
		JPanel checkPanel = new JPanel(new GridLayout(0, 1));
		for (int i = 0; i < 3; i++) {
			checkPanel.add(buttons[i]);
		}
		
		three.add(checkPanel);
		three.add(pictureLabel[0]);
		three.add(pictureLabel[1]);
		three.add(pictureLabel[2]);
		
		// four
		topPanel = new JPanel();
		JLabel label = new JLabel("What size of coffee do you like to order?");
		topPanel.add(label);
		four.add(topPanel, BorderLayout.NORTH);
		
		sizePanel = new JPanel();
		small = new JRadioButton("Small size");
		medium = new JRadioButton("Medium size");
		large = new JRadioButton("Large size");
		
		ButtonGroup size = new ButtonGroup();
		size.add(small);
		size.add(medium);
		size.add(large);
		
		small.addActionListener(this);
		medium.addActionListener(this);
		large.addActionListener(this);
		
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		
		four.add(sizePanel, BorderLayout.CENTER);
		
		resultPanel = new JPanel();
		text = new JLabel("Did not select the size.");
		text.setForeground(Color.red);
		resultPanel.add(text);
		
		four.add(resultPanel, BorderLayout.SOUTH);
		
		// Tab 추가
		tabpane.addTab("SMU", one);
		tabpane.addTab("CAT", two);
		tabpane.addTab("FRUIT", three);
		tabpane.addTab("ORDER", four);
		
		// tabpane 추가
		jf.getContentPane().add(tabpane, BorderLayout.CENTER);
	}
	
	// 과일 선택하면 사진을 출력하는 이벤트 함수
	public void itemStateChanged(ItemEvent e) {
		ImageIcon image = null;
		Object source = e.getItemSelectable();
		for(int i = 0; i < 3; i++) {
			if (source == buttons[i]) {
				if (e.getStateChange() == ItemEvent.DESELECTED)
					pictureLabel[i].setIcon(null);
				else
					pictureLabel[i].setIcon(icon[i]);
			}		
		}
	}
	
	// 주문 관련 이벤트 함수
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == small) {
			text.setText("Ordered Small Size.");
		}
		if (e.getSource() == medium) {
			text.setText("Ordered Medium Size.");
		}
		if (e.getSource() == large) {
			text.setText("Ordered Large Size.");
		}
	}

	public static void main(String[] args) {
		new TabTest("TabPane Test:김민지");
	}

}
