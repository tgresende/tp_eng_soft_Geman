package UIComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import UIClasses.Colors;

public class Header {
	
	JPanel panel;
	JLabel text;
	JButton button;
	
	
	public JPanel getHeader(String label, JButton returnButton) {
		text = new JLabel(label);
		button = returnButton;
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		panel.setBorder(raisedbevel);

		
		text.setLocation(50, 50);
		text.setBackground(Colors.getMainBlack());
		text.setFont(new Font("Arial", Font.BOLD, 24));
		
		panel.setMaximumSize(new Dimension(655, 50));
		panel.setLocation(0,0);
		panel.setBackground(Colors.getMainWhite());
		
		panel.add(returnButton,BorderLayout.WEST);
		panel.add(text,BorderLayout.CENTER);
		
		return panel;
	}

}
