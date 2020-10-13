package UIComponents;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import UIClasses.Colors;

public class GoBackButton {

	JButton goBackBtn =  new JButton();
	
	public JButton getButton(ActionListener action){
		goBackBtn.setPreferredSize(new Dimension(30,30));
		goBackBtn.setBackground(Colors.getMainWhite());
		goBackBtn.addActionListener(action);
		try {
			ImageIcon img = new ImageIcon(getClass().getResource("/assets/left-arrow.png"));
			goBackBtn.setIcon(img);
		}catch (Exception ex) {
		    System.out.println(ex);
		}
		
		return goBackBtn;
	}
	
}
