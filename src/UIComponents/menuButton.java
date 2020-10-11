package UIComponents;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import UIClasses.BordaArredondada;
import UIClasses.Cores;

public class menuButton {

	JButton primaryButton;
	Cores cor = new Cores();

	public JButton getButton(String label, ActionListener action) {
		primaryButton = new JButton();
		primaryButton.setText(label);
		setButtonStyle();
		primaryButton.addActionListener(action);
		return primaryButton;
	}

	public void setButtonStyle() {
		primaryButton.setMaximumSize(new Dimension(655, 100));
		primaryButton.setPreferredSize(new Dimension(100, 100));
		primaryButton.setFont(new Font("Arial", Font.PLAIN, 16));
		primaryButton.setBorder(new BordaArredondada(10));
		primaryButton.setBackground(cor.getPretoPrincipal());
		primaryButton.setForeground(cor.getBrancoPrincipal());
	}
	
}
