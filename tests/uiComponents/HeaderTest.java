package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.Header;

public class HeaderTest {

	
	@Test
	public void testHeader() {
		JPanel header = Header.getHeader("TESTE");
		assertEquals(new Point(0,0), header.getLocation());
		assertEquals(new Dimension(655, 50), header.getMaximumSize());
		assertEquals(Colors.getMainWhite(), header.getBackground());
	}
	
	@Test
	public void testHeaderWithBackButton() {
		JPanel header = Header.getHeader("TESTE", new JButton());
		assertEquals(new Point(0,0), header.getLocation());
		assertEquals(new Dimension(655, 50), header.getMaximumSize());
		assertEquals(Colors.getMainWhite(), header.getBackground());
	}
}
