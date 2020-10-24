package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.TextFieldContainer;

public class TextFieldContainerTest {

	@Test
	public void textFieldContainerTest() {
		List<JTextField> list = new ArrayList<JTextField>();
		list.add(new JTextField());
		
		List<JLabel> labels = new ArrayList<JLabel>();
		labels.add(new JLabel());
		
		JPanel panel = TextFieldContainer.getContainer(list, labels);
		
		assertEquals(new Dimension(500, 200), panel.getMaximumSize());
		assertEquals(new Dimension(500, 200), panel.getMinimumSize());
		assertEquals(new Point(0,0), panel.getLocation());
		assertEquals(Colors.getMainWhite(), panel.getBackground());
		
	}
}
