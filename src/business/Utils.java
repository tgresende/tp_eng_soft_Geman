package business;

public final class Utils {
	
	public static String convertDayMonthYearToDateString(int day, int month, int year) {
		
		if (day>=1 && day<=31 && month>=1 && month <=12 && year >= 2015) {
			return  Integer.toString(day)+"/"+
					Integer.toString(month)+"/"+
					Integer.toString(year);
		}

		return "";
	}

}
