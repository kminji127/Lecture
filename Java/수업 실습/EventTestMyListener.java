import java.awt.event.*;
import javax.swing.*;

public class EventTestMyListener implements ActionListener {

	JLabel label;
	
	public EventTestMyListener(JLabel l) {
		label = l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		label.setText("Clicked the Button");
	}

}
