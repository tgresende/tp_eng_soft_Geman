package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.MenuButton;

public class MenuButtonTest {

	@Test
	public void menuButtonTest() throws ParseException {
		
		JButton button = MenuButton.getButton("testes",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		assertEquals(new Dimension(100,100), button.getPreferredSize());
		assertEquals(Colors.getMainBlack(), button.getBackground());
		assertEquals(Colors.getMainWhite(), button.getForeground());
		
	}
	
}
