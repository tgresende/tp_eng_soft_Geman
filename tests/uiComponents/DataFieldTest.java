package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

import org.junit.Test;

import UIComponents.DateField;

public class DataFieldTest {

	@Test
	public void dataFieldTest() throws ParseException {
		JFormattedTextField field = DateField.getDateField("01012020");
		assertEquals(new Dimension(90,25), field.getPreferredSize());
		assertEquals("01/01/2020", field.getText());
		
	}
	
}
