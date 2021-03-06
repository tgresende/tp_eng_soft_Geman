package presentation;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {
	
	@Test
	public void testIsValidDateReturningTrue(){
		// when I have...
		String date = "20/08/1991";

		// when I do...
		boolean result = Utils.isValidDate(date);

		// I expect.
		assertEquals(true,result);
	}
	
	@Test
	public void testIsValidDateReturningFalseWithDayError(){
		// when I have...
		String date = "32/08/1991";

		// when I do...
		boolean result = Utils.isValidDate(date);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testIsValidDateReturningFalseWithMonthError(){
		// when I have...
		String date = "30/13/1991";

		// when I do...
		boolean result = Utils.isValidDate(date);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testIsValidDateReturningFalseWithYearError(){
		// when I have...
		String date = "31/08/1500";

		// when I do...
		boolean result = Utils.isValidDate(date);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testIsValidDateReturningFalseIncompleteError(){
		// when I have...
		String date = "31/08/202";

		// when I do...
		boolean result = Utils.isValidDate(date);

		// I expect.
		assertEquals(result,false);
	}
	
	
	@Test
	public void testIsValidTimeReturningTrue(){
		// when I have...
		String time = "11:55";

		// when I do...
		boolean result = Utils.isValidTime(time);

		// I expect.
		assertEquals(result,true);
	}
	
	@Test
	public void testIsValidTimeReturningFalseHourError(){
		// when I have...
		String time = "25:55";

		// when I do...
		boolean result = Utils.isValidTime(time);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testIsValidTimeReturningFalseMinuteError(){
		// when I have...
		String time = "11:72";

		// when I do...
		boolean result = Utils.isValidTime(time);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testIsValidTimeReturningFalseIncompleteError(){
		// when I have...
		String time = "11:2";

		// when I do...
		boolean result = Utils.isValidTime(time);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testReplaceCommaToDot(){
		// when I have...
		String text = "abc";

		// when I do...
		String result = Utils.replaceCommaToDot(text);

		// I expect.
		assertEquals(result,text);
	}
	
	@Test
	public void testReplaceCommaToDotWithDot(){
		// when I have...
		String text = "abc.";

		// when I do...
		String result = Utils.replaceCommaToDot(text);

		// I expect.
		assertEquals(result,text);
	}
	
	@Test
	public void testReplaceCommaToDotWithComma(){
		// when I have...
		String text = "abc,";

		// when I do...
		String result = Utils.replaceCommaToDot(text);

		// I expect.
		assertEquals(result,"abc.");
	}
	
	@Test
	public void testOnlyNumbers(){
		// when I have...
		String text = "abc8";

		// when I do...
		String result = Utils.onlyNumbers(text);

		// I expect.
		assertEquals(result,"8");
	}
	
	@Test
	public void testOnlyNumbersWithoutNumbers(){
		// when I have...
		String text = "abc";

		// when I do...
		String result = Utils.onlyNumbers(text);

		// I expect.
		assertEquals(result,"0");
	}
	
}
