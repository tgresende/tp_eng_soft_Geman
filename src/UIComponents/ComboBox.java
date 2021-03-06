package UIComponents;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;

import UIClasses.Colors;

public final class ComboBox {
	static JComboBox comboBox;
	
	private static void estilyzeComboBox() {
		comboBox.setPreferredSize(new Dimension(200,30));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBackground(Colors.getMainWhite());
	}
	
	public static JComboBox getComboBox(String[] list) {
		comboBox =  new JComboBox(list);
		estilyzeComboBox();
		return comboBox;
	}
}
