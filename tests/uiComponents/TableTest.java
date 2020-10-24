package uiComponents;

import static org.junit.Assert.assertEquals;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.Table;

public class TableTest {

	@Test
	public void testHeader() {
		JTable table = Table.getTable(new DefaultTableModel());
        
		assertEquals(Colors.getMainWhite(), table.getTableHeader().getBackground());
		assertEquals(Colors.getMainWhite(), table.getBackground());
	}
}
