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
		String date  = Utils.convertDayMonthYearToDateString(day, month, year, true);

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
		String date  = Utils.convertDayMonthYearToDateString(day, month, year, true);

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
		String date  = Utils.convertDayMonthYearToDateString(day, month, year, true);

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
		String date  = Utils.convertDayMonthYearToDateString(day, month, year, true);

		// I expect.
		assertEquals(date,"");
	}
	
	@Test
	public void isTime1GreaterThanTime2ReturningTrue(){
		// when I have...
		String time1 = "08:00";
		String time2 = "07:59";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,true);
	}
	
	@Test
	public void isTime1GreaterThanTime2ReturningFalseEqualTime(){
		// when I have...
		String time1 = "08:00";
		String time2 = "08:00";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void isTime1GreaterThanTime2ReturningFalse(){
		// when I have...
		String time1 = "08:00";
		String time2 = "08:01";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,false);
	}
	
	
	
	
}
