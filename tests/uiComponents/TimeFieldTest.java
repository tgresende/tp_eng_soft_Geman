package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

import org.junit.Test;

import UIComponents.TimeField;

public class TimeFieldTest {
	
	@Test
	public void timeFieldTest() throws ParseException {
		JFormattedTextField field = TimeField.getTimeField("0101");
		assertEquals(new Dimension(45,25), field.getPreferredSize());
		assertEquals("01:01", field.getText());
		
	}
	
}
