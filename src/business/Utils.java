package business;

public final class Utils {
	
	public static String convertDayMonthYearToDateString(int day, int month, int year) {
		
		return  Integer.toString(day)+"/"+
				Integer.toString(month)+"/"+
				Integer.toString(year);
	}

}
