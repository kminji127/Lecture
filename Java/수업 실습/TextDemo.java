import java.awt.*;

public class TextDemo extends Frame {

	TextField field;
	TextArea text;
	
	public TextDemo(String msg) {
		super(msg);
		setLayout(new FlowLayout());
		setSize(300, 200);
		setVisible(true);
		
		field = new TextField(30);
		char c = '*';
		field.setEchoChar(c);
		add(field);

		text = new TextArea("Hello", 5, 30);
		add(text);
		
	}

}
