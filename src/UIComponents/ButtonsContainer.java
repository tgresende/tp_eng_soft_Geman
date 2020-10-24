package UIComponents;

import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import UIClasses.Colors;

public final class ButtonsContainer {

	public static JPanel getContainer(List<JButton> buttons) {
		
		JPanel panel = new JPanel();

		for (JButton button : buttons) {
			panel.add(button);
		}
		
		panel.setMaximumSize(new Dimension(650, 50));
		panel.setMinimumSize(new Dimension(650, 50));
		
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Colors.getMainBlack()));
		
		panel.setLocation(0,0);
		panel.setBackground(Colors.getMainWhite());
		

		return panel;
	}
}
