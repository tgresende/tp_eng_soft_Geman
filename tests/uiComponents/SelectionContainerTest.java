package uiComponents;

import static org.junit.Assert.assertEquals;

import javax.swing.JScrollPane;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.SelectionContainer;

public class SelectionContainerTest {

	@Test
	public void selectionContainerTest(){
		JScrollPane scroll = SelectionContainer.getPanel();

		assertEquals(Colors.getMainWhite(), scroll.getBackground());
	}
	
}
