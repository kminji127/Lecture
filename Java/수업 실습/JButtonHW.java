import java.awt.event.*;
import javax.swing.*;

public class JButtonHW implements ActionListener {

	JFrame jf;
	JPanel panel;
	JLabel label;
	JButton button;
	ImageIcon icon;
	
	JLabel imgLabel; // 사진을 보여주는 JLabel 추가
	boolean current = false; // 현재 사진이 없는 상태임을 표현
	
	public JButtonHW(String msg) {
		jf = new JFrame(msg);
		jf.setVisible(true);
		jf.setSize(700, 700);
		
		panel = new JPanel();
		label = new JLabel("고양이를 보고 싶으면 버튼을 누르세요.");
		imgLabel = new JLabel(); // 사진을 보여주는 JLabel
		button = new JButton("See Image");
		
		button.setIcon(icon);
		button.addActionListener(this);
		
		panel.add(imgLabel);
		panel.add(label);
		panel.add(button);
		
		jf.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if(current) { // 사진이 없을 때 (current=true)
			imgLabel.setIcon(null);
			label.setText("고양이를 보고 싶으면 버튼을 누르세요.");
			current = false;
		} else { // 사진이 있을 때 (current=false)
			ImageIcon cat = new ImageIcon("cat.jpg");
			imgLabel.setIcon(cat);
			label.setText("초기 화면으로 가려면 버튼을 누르세요.");
			button.setText("Go Back");
			current = true;
		}
		
	}
}
