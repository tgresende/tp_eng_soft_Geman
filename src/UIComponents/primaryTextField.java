package UIComponents;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

import UIClasses.Cores;

public class primaryTextField {
	JTextField JTextField;
	Cores cor = new Cores();

	public JTextField getTextField(String label) {
		JTextField = new JTextField();
		JTextField.setText(label);
		setTextFieldStyle();
		return JTextField;
	}
	
	public void setTextFieldStyle() {
		JTextField.setPreferredSize(new Dimension(200,30));
		JTextField.setFont(new Font("Arial", Font.PLAIN, 16));
	}
	
}
