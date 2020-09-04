package UIComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import UIComponents_Interface.IButton;

public class primaryButton implements IButton{
	
	JButton primaryButton;
	ActionListener action;

	public JButton getButton(String label, ActionListener action) {
		primaryButton = new JButton();
		this.action = action;
		primaryButton.setText(label);
		setButtonStyle();
		
		primaryButton.addActionListener(action);
		
		return primaryButton;
	}
	

	@Override
	public void setButtonStyle() {
		primaryButton.setBackground(Color.blue);
		primaryButton.setSize(new Dimension(100,100));
	}
	
	
	
	
	
}
