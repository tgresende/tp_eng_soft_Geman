package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.JTextField;

import org.junit.Test;

import UIComponents.PrimaryTextField;

public class PrimaryTextFieldTest {

	@Test
	public void menuButtonTest() throws ParseException {
		
		JTextField text = PrimaryTextField.getTextField("testes");
		
		assertEquals(new Dimension(200,30), text.getPreferredSize());
		assertEquals("testes", text.getText());
	}
}
