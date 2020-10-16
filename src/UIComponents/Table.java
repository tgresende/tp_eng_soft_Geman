package UIComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public final class Table {
	
	static JTable table;
	
	private static void estilyzeTable() {
        table.setFont(new Font("", 1, 14));
        table.setBackground(Color.white);
        table.getTableHeader().setBackground(Color.white);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
	}
	
	public static JTable getTable(DefaultTableModel model) {
		table =  new JTable(model);
		estilyzeTable();
		return table;
	}

}
