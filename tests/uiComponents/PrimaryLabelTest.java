package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import javax.swing.JLabel;

import org.junit.Test;

import UIComponents.PrimaryLabel;

public class PrimaryLabelTest {

	@Test
	public void primaryLabelTest() {
		JLabel label = PrimaryLabel.getLabel("teste");
		
		assertEquals(new Dimension(100,40), label.getPreferredSize());
		assertEquals("teste", label.getText());
	}
}
