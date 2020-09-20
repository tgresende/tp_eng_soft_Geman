package UIComponents;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Desktop.Action;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UIClasses.Cores;

public class Header {
	
	JPanel panel;
	JLabel text;
	JButton button;
	
	Cores cor = new Cores();
	
	
	

	
	public JPanel getHeader(String label, JButton returnButton) {
		text = new JLabel(label);
		button = returnButton;
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		returnButton.setLocation(200, 50);
		
		text.setLocation(50, 50);
		text.setBackground(cor.getPretoPrincipal());
		text.setFont(new Font("Arial", Font.BOLD, 18));
		
		panel.setSize(new Dimension(660, 30));
		panel.setLocation(0,0);
		panel.setBackground(cor.getBrancoPrincipal());
		
		panel.add(returnButton,BorderLayout.WEST);
		panel.add(text,BorderLayout.CENTER);
		
		return panel;
	}

}
