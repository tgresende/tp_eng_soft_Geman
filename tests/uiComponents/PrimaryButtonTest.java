package uiComponents;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;

import org.junit.Test;

import UIClasses.Colors;
import UIComponents.PrimaryButton;

public class PrimaryButtonTest {

	@Test
	public void primaryButtonTest() throws ParseException {
		
		JButton button = PrimaryButton.getButton("testes",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		assertEquals(Colors.getMainBlack(), button.getBackground());
		
	}
}
