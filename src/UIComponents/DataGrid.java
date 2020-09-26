package UIComponents;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DataGrid {

    JTable table;
    JPanel panel;
    JScrollPane rollBar;

	public JPanel getGrid ( Object [][] data, String [] columnTitle) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		table = new JTable(data, columnTitle);
        rollBar = new JScrollPane(table);
        panel.add(rollBar);

		return panel;
	}
	
}
