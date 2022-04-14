import javax.swing.*;
import javax.swing.table.*;

public class JTableTest3 extends JFrame {

	TableModel model;
	JTable table;
	JScrollPane sp;
	JComboBox comboBox;
	
	public JTableTest3(String msg) {
		super(msg);
		setSize(400, 300);
		setVisible(true);
		
		model = new TableModel();
		table = new JTable(model);
		setUpDeptColumn(table.getColumnModel().getColumn(2));
		
		sp = new JScrollPane(table);
		getContentPane().add(sp, "Center");
		
	}

	public void setUpDeptColumn(TableColumn deptColumn) {
		comboBox = new JComboBox();
		comboBox.addItem("Dev.");
		comboBox.addItem("Research");
		comboBox.addItem("Finance");
		deptColumn.setCellEditor(new DefaultCellEditor(comboBox));
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("Click for combo box");
		deptColumn.setCellRenderer(renderer);
		
		TableCellRenderer headerRenderer = deptColumn.getHeaderRenderer();
		if(headerRenderer instanceof DefaultTableCellRenderer) {
			((DefaultTableCellRenderer)headerRenderer).setToolTipText("Click");
		}
		
	}

}
