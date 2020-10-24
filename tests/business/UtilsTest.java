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
	public void testConvertDayMonthYearToDateStringReturningRightValueWithoutMask(){
		// when I have...
		int day = 20;
		int month = 10;
		int year = 2020;

		// when I do...
		String date  = Utils.convertDayMonthYearToDateString(day, month, year, false);

		// I expect.
		assertEquals(date,"20102020");
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
	public void testConvertDayMonthYearToDateStringWithErrorMonth_2(){
		// when I have...
		int day = 20;
		int month = -1;
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
	public void testConvertDayMonthYearToDateStringWithErrorDay_2(){
		// when I have...
		int day = -20;
		int month = 10;
		int year = 2018;

		// when I do...
		String date  = Utils.convertDayMonthYearToDateString(day, month, year, true);

		// I expect.
		assertEquals(date,"");
	}
	
	@Test
	public void testIsTime1GreaterThanTime2ReturningFalseInvalidTime1(){
		// when I have...
		String time1 = "08:00";
		String time2 = "07:529";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testIsTime1GreaterThanTime2ReturningFalseInvalidTime2(){
		// when I have...
		String time1 = "08:010";
		String time2 = "07:59";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void itestITime1GreaterThanTime2ReturningFalseInvalidTime1_2(){
		// when I have...
		String time1 = "08:0";
		String time2 = "07:59";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testIsTime1GreaterThanTime2ReturningFalseInvalidTime2_2(){
		// when I have...
		String time1 = "08:00";
		String time2 = "07:5";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testIsTime1GreaterThanTime2ReturningTrue(){
		// when I have...
		String time1 = "08:00";
		String time2 = "07:59";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,true);
	}
	
	@Test
	public void testIsTime1GreaterThanTime2ReturningFalseEqualTime(){
		// when I have...
		String time1 = "08:00";
		String time2 = "08:00";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testIsTime1GreaterThanTime2ReturningFalse(){
		// when I have...
		String time1 = "08:00";
		String time2 = "08:01";

		// when I do...
		boolean result = Utils.isTime1GreaterThanTime2(time1, time2);

		// I expect.
		assertEquals(result,false);
	}
	
	@Test
	public void testConvertToTimeStringWithoutMask(){
		// when I have...
		int hour = 8;
		int minute = 30;

		// when I do...
		String result = Utils.ConvertToTimeStringWithoutMask(hour, minute);

		// I expect.
		assertEquals(result,"0830");
	}
	
	@Test
	public void testConvertToTimeStringWithoutMask_2(){
		// when I have...
		int hour = 8;
		int minute = 0;

		// when I do...
		String result = Utils.ConvertToTimeStringWithoutMask(hour, minute);

		// I expect.
		assertEquals(result,"0800");
	}
	
	@Test
	public void testConvertToTimeStringWithoutMask_3(){
		// when I have...
		int hour = 18;
		int minute = 3;

		// when I do...
		String result = Utils.ConvertToTimeStringWithoutMask(hour, minute);

		// I expect.
		assertEquals(result,"1803");
	}
	
	
	
}
