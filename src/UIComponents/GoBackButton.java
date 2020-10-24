package UIComponents;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import UIClasses.Colors;

public final class GoBackButton {

	static JButton goBackBtn =  new JButton();
	ImageIcon img ;
	
	private static void estilyzeButton(ImageIcon img) {
		goBackBtn.setPreferredSize(new Dimension(30,30));
		goBackBtn.setBackground(Colors.getMainWhite());
		goBackBtn.setIcon(img);
	}
	
	public JButton getButton(ActionListener action){
		img = new ImageIcon(getClass().getResource("/assets/left-arrow.png"));
		estilyzeButton(img);
		
		goBackBtn.addActionListener(action);		
		return goBackBtn;
	}
	
	public JButton getButton(){
		estilyzeButton(img);
		return goBackBtn;
	}
	
	
	
}
