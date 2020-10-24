package UIComponents;

import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import UIClasses.Colors;

public final class DateField {
	static JFormattedTextField textField;
	static Colors cor = new Colors();

	public static JFormattedTextField getDateField(String date) throws ParseException {
		MaskFormatter mask = new MaskFormatter();
		mask.setMask("##/##/####");
        mask.setPlaceholderCharacter('_'); 
		textField = new JFormattedTextField(mask);
		setTextFieldStyle();
		textField.setText(date);
		return textField;
	}
	
	public static void setTextFieldStyle() {
		textField.setPreferredSize(new Dimension(90,25));
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		
	}
	
}
