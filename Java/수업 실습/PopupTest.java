import java.awt.*;
import java.awt.event.*;

public class PopupTest extends Frame implements ActionListener {

	PopupMenu popup;
	Button b;
	
	public PopupTest() {
		super("Popup Test");
		setSize(300, 200);
		setVisible(true);
		
		b = new Button("POPUPTEST");
		b.addActionListener(this);
		
		popup = new PopupMenu("POP-UP"); // 팝업메뉴 생성
		popup.add(new MenuItem("copy"));
		popup.add(new MenuItem("paste"));
		
		Menu col = new Menu("Color");
		col.add(new MenuItem("white"));
		col.add(new MenuItem("blue"));
		popup.add(col);
		
		b.add(popup); // 버튼에 팝업 추가
		
		add("Center", b); // 프레임에 버튼 추가
		
	}
	
	// implementation for ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		popup.show(b, 10, 10);
		
	}

}
