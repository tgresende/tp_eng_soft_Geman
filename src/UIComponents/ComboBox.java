package UIComponents;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;

import UIClasses.Colors;

public class ComboBox {
	JComboBox comboBox;
	
	private void estilyzeComboBox() {
		comboBox.setPreferredSize(new Dimension(200,30));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBackground(Colors.getMainWhite());
	}
	
	public JComboBox getComboBox(String[] list) {
		comboBox =  new JComboBox(list);
		estilyzeComboBox();
		return comboBox;
	}
}
