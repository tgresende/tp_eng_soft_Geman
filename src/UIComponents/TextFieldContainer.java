package UIComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UIClasses.Cores;

public class TextFieldContainer {
	JPanel panel;
	JLabel text;
	
	Cores cor = new Cores();
	
	public JPanel getContainer(List<JTextField> textFields, List<JLabel> labels) {
		panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
		
		
		int i = 0;
		for (JTextField textField : textFields) {
			panel.add(labels.get(i));
			panel.add(textField);
			i++;
			
		}
		
		panel.setMaximumSize(new Dimension(500, 200));
		panel.setMinimumSize(new Dimension(500, 200));
		
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		panel.setLocation(0,0);
		panel.setBackground(cor.getBrancoPrincipal());
		
		return panel;
	}
	
	

}
