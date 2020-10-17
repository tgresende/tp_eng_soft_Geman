package UIComponents;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import UIClasses.Colors;

public class GoBackButton {

	JButton goBackBtn =  new JButton();
	
	private void estilyzeButton() {
		goBackBtn.setPreferredSize(new Dimension(30,30));
		goBackBtn.setBackground(Colors.getMainWhite());
		try {
			ImageIcon img = new ImageIcon(getClass().getResource("/assets/left-arrow.png"));
			goBackBtn.setIcon(img);
		}catch (Exception ex) {
		    System.out.println(ex);
		}
	}
	
	public JButton getButton(ActionListener action){
		estilyzeButton();
		goBackBtn.addActionListener(action);		
		return goBackBtn;
	}
	
	public JButton getButton(){
		estilyzeButton();
		return goBackBtn;
	}
	
	
	
}
