package UIComponents;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import UIClasses.Colors;

public final class FieldLabel {

	static JLabel label;
	static Colors cor = new Colors();

	public JLabel getLabel(String labelText) {
		label = new JLabel(labelText);
		setLabelStyle();
		return label;
	}

	public void setLabelStyle() {
		label.setPreferredSize(new Dimension(100,40));
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
	}
}
