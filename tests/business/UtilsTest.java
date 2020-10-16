package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {
	
	@Test
	public void testConvertDayMonthYearToDateStringReturningRightValue(){
		// when I have...
		int day = 20;
		int month = 10;
		int year = 2020;

		// when I do...
		String date  = Utils.convertDayMonthYearToDateString(day, month, year);

		// I expect.
		assertEquals(date,"20/10/2020");
	}
	
	@Test
	public void testConvertDayMonthYearToDateStringWithErrorDay(){
		// when I have...
		int day = 2320;
		int month = 10;
		int year = 2020;

		// when I do...
		String date  = Utils.convertDayMonthYearToDateString(day, month, year);

		// I expect.
		assertEquals(date,"");
	}
	
	@Test
	public void testConvertDayMonthYearToDateStringWithErrorMonth(){
		// when I have...
		int day = 20;
		int month = 110;
		int year = 2020;

		// when I do...
		String date  = Utils.convertDayMonthYearToDateString(day, month, year);

		// I expect.
		assertEquals(date,"");
	}
	
	@Test
	public void testConvertDayMonthYearToDateStringWithErrorYear(){
		// when I have...
		int day = 20;
		int month = 10;
		int year = 200;

		// when I do...
		String date  = Utils.convertDayMonthYearToDateString(day, month, year);

		// I expect.
		assertEquals(date,"");
	}
}
