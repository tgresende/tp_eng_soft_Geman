package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.JLabel;

import org.junit.Test;

import UIComponents.FieldLabel;

public class FieldLabelTest {

	@Test
	public void dataFieldTest() throws ParseException {
		JLabel label = FieldLabel.getLabel("teste");
		
		assertEquals(new Dimension(100,40), label.getPreferredSize());
		assertEquals("teste", label.getText());
	}
}
