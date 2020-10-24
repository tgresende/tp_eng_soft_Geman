package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import javax.swing.JComboBox;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.ComboBox;

public class ComboBoxTest {

	
	@Test
	public void buttonsContainerTest() {
		String[] list = new String[] {"teste", "teste2"};
		JComboBox comboBox = ComboBox.getComboBox(list);
		assertEquals(new Dimension(200, 30), comboBox.getPreferredSize());
		assertEquals(Colors.getMainWhite(), comboBox.getBackground());
	}
}
