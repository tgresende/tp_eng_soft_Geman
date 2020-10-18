package UIComponents;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import UIClasses.Colors;

public final class PrimaryLabel {
	static JLabel JLabel;
	static Colors cor = new Colors();
	
	public static JLabel getLabel(String label) {
		JLabel = new JLabel();
		JLabel.setText(label);
		setlabelStyle();
		return JLabel;
	}

	private static void setlabelStyle() {
		JLabel.setPreferredSize(new Dimension(100,40));
		JLabel.setFont(new Font("Arial", Font.BOLD, 16));
	}
}
