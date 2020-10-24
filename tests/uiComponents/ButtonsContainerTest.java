package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.ButtonsContainer;

public class ButtonsContainerTest {

	@Test
	public void buttonsContainerTest() {
		List<JButton> list = new ArrayList<JButton>();
		list.add(new JButton());
		
		JPanel panel = ButtonsContainer.getContainer(list);
		
		assertEquals(new Dimension(650, 50), panel.getMaximumSize());
		assertEquals(new Dimension(650, 50), panel.getMinimumSize());
		assertEquals(new Point(0,0), panel.getLocation());
		assertEquals(Colors.getMainWhite(), panel.getBackground());
		
	}
}
