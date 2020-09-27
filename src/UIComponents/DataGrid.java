package UIComponents;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataGrid {

    JTable table;
    JPanel panel;
    JScrollPane rollBar;
    DefaultTableModel model;

	public JPanel getTablePanel(DefaultTableModel model) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		table = new JTable(model);
		rollBar = new JScrollPane(table);
		panel.add(rollBar);
		return panel;
	}
	
}
