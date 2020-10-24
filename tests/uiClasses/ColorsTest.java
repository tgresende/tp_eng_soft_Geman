package uiClasses;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import org.junit.Test;

import UIClasses.Colors;

public class ColorsTest {

	@Test
	public void getMainBlackTest() {
		assertEquals(Color.black,Colors.getMainBlack());
	}
	
	@Test
	public void getMainWhiteTest() {
		assertEquals(Color.white,Colors.getMainWhite());	
	}
}
