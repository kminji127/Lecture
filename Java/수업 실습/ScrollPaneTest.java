import java.awt.*;

public class ScrollPaneTest extends Frame {
	
	ScrollPane sp;
	Panel mpanel, bpanel;
	TextArea ta;
	Button ok, cancel;
	
	
	public ScrollPaneTest() {
		super("ScrollPaneTest"); // 프레임
		setSize(200, 200);
		setVisible(true);
		
		sp = new ScrollPane(); // ScrollPane
		sp.setSize(150, 100);
		
		// 메인 패널
		mpanel = new Panel();
		mpanel.setSize(500, 450);
		mpanel.setLayout(new BorderLayout());
		ta = new TextArea();
		mpanel.add("Center", ta); // 메인 패널 중간에 TextArea 삽입
//	    mpanel.add("Center", new TextArea());
		
		// 메인 패널 속의 하단 패널
		bpanel = new Panel();
		ok = new Button("OK");
		cancel = new Button("CANCEL");
		bpanel.add(ok);
		bpanel.add(cancel);
		mpanel.add("South", bpanel); // 메인 패널 남쪽에 bpanl 삽입
		
		sp.add(mpanel); // ScrollPane에 메인 패널 삽입
		add("Center", sp); // 프레임에 ScrollPane 삽입
	}

}
