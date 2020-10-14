package UIComponents;

import javax.swing.JComboBox;

public class ComboBox {

	
	public JComboBox getComboBox(String[] list) {
		JComboBox comboBox =  new JComboBox(list);
		
		return comboBox;
	}
}
