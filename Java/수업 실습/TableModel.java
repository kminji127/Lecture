import javax.swing.*;
import javax.swing.table.*;

public class TableModel extends AbstractTableModel {
	String[] columnName = {"Name", "Age", "Dept.", "Good ?"};
	
	@SuppressWarnings("deprecation")
	Object[][] data	= {
			{"Kim", new Integer(20), "Statistic", new Boolean(false)},
			{"Yoon", new Integer(30), "IT Engineering", new Boolean(true)},
			{"Park", new Integer(40), "Research", new Boolean(false)},
			{"Lee", new Integer(50), "Finance", new Boolean(true)}
	};
	
	// 관련 함수
	public int getColumnCount() {
		return columnName.length;
	}
	
	public int getRowCount() {
		return data.length;
	}
	
	public String getColumnName(int col) {
		return columnName[col];
	}
	
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public boolean isCellEditable(int row, int col) {
		return true;
	}
	
	// 특정 column의 값 세팅
	public void setValueAt(Object value, int row, int col) {
		if(data[0][col] instanceof Integer) {
			try {
				data[row][col] = new Integer((String)value);
			} catch (NumberFormatException e) {
				System.err.println("User attempted to enter non-integer");
			}
		} else {
			data[row][col] = value;
		}
	}
}
