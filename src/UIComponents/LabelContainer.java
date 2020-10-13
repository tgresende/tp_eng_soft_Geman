package UIComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UIClasses.Colors;

	public class LabelContainer {
		JPanel panel = new JPanel();;
		JLabel text;
		
	public JPanel getContainer(List<JLabel> labels) {
	
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (JLabel label : labels) {
			panel.add(label);
		}
		
		panel.setMaximumSize(new Dimension(500, 200));
		panel.setMinimumSize(new Dimension(500, 200));
		
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		panel.setLocation(0,0);
		panel.setBackground(Colors.getMainWhite());
		
		return panel;
	}
}
