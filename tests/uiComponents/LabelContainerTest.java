package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.LabelContainer;

public class LabelContainerTest {

	@Test
	public void LabelContainTest(){
		java.util.List<JLabel> labels = new ArrayList<JLabel>();
		labels.add(new JLabel());
		
		JPanel panel = LabelContainer.getContainer(labels);
		assertEquals(new Dimension(500,200), panel.getMaximumSize());
		assertEquals(Colors.getMainWhite(), panel.getBackground());
	}
}
