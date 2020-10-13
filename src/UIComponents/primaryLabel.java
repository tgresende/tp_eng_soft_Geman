package UIComponents;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import UIClasses.Colors;

public class primaryLabel {
	JLabel JLabel;
	Colors cor = new Colors();
	
	public JLabel getLabel(String label) {
		JLabel = new JLabel();
		JLabel.setText(label);
		setlabelStyle();
		return JLabel;
	}

	private void setlabelStyle() {
		JLabel.setPreferredSize(new Dimension(100,40));
		JLabel.setFont(new Font("Arial", Font.BOLD, 16));
	}
}
