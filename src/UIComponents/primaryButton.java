package UIComponents;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import UIClasses.RoundedBorder;
import UIClasses.Colors;

public class primaryButton{
	
	JButton primaryButton;

	public JButton getButton(String label, ActionListener action) {
		primaryButton = new JButton();
		primaryButton.setText(label);
		setButtonStyle();
		primaryButton.addActionListener(action);
		return primaryButton;
	}
	

	public void setButtonStyle() {
		primaryButton.setPreferredSize(new Dimension(100,40));
		primaryButton.setFont(new Font("Arial", Font.PLAIN, 16));
		primaryButton.setBorder(new RoundedBorder(10));
		primaryButton.setBackground(Colors.getMainBlack());
		primaryButton.setForeground(Colors.getMainWhite());
	}
	
	
	
	
	
}
