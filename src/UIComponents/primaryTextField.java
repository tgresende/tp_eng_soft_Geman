package UIComponents;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

import UIClasses.Colors;

public final class primaryTextField {
	static JTextField JTextField;
	static Colors cor = new Colors();

	public static JTextField getTextField(String label) {
		JTextField = new JTextField();
		JTextField.setText(label);
		setTextFieldStyle();
		return JTextField;
	}
	
	public static void setTextFieldStyle() {
		JTextField.setPreferredSize(new Dimension(200,30));
		JTextField.setFont(new Font("Arial", Font.PLAIN, 16));
	}
	
}
