package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.GoBackButton;

public class GoBackButtonTest {


	@Test
	public void goBackButtonTest() {
		GoBackButton constructor = new GoBackButton();
		JButton button = constructor.getButton();
		
		
		assertEquals(new Dimension(30,30), button.getPreferredSize());
		assertEquals(Colors.getMainWhite(), button.getBackground());
		
	}
	
	@Test
	public void goBackButtonTestWithAction() {
		GoBackButton constructor = new GoBackButton();
		JButton button = constructor.getButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		assertEquals(new Dimension(30,30), button.getPreferredSize());
		assertEquals(Colors.getMainWhite(), button.getBackground());
		
	}
}
