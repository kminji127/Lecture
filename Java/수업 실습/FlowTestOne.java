import java.awt.*;

public class FlowTestOne extends Frame {

	public FlowTestOne() {
		super("FlowTestOne");
		setSize(300, 200);
		setVisible(true);
		
		// 오른쪽 정렬, 컴포넌트 간 좌우간격 0픽셀, 상하간격 1픽셀
		setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 1));
		
		add(new Button("1"));
		add(new Button("2"));
		add(new Button("3"));
		add(new Button("4"));
		add(new Button("5"));
		add(new Button("6"));
		add(new Button("7")).setVisible(false);;
		add(new Button("8"));
		add(new Button("9"));
		add(new Button("10"));
		add(new Button("11"));
	}

}
