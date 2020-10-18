package business;

public final class Utils {
	
	public static String leftZeros(int number, int lengthNumber) {
		String numberAux =  Integer.toString(number);
		
		while(numberAux.length()<lengthNumber)
			numberAux = "0"+numberAux;
		
		return numberAux;
	}
	
	public static String convertDayMonthYearToDateString(int day, int month, int year, boolean withMask) {
		if (day>=1 && day<=31 && month>=1 && month <=12 && year >= 2015) {
			if (withMask)
				return  leftZeros(day,2)+"/"+
						leftZeros(month,2)+"/"+
						Integer.toString(year);
			
			return  leftZeros(day,2)+
					leftZeros(month,2)+
					Integer.toString(year);
			
		}

		return "";
	}
	
	public static String ConvertToTimeStringWithoutMask(int hour, int minute) {
		return  leftZeros(hour,2)+
				leftZeros(minute,2);

	}

	public static boolean isTime1GreaterThanTime2(String time1, String time2) {
		
		if (time1.length() != 5)
			return false;
		
		if (time2.length() != 5)
			return false;
		
		int hour1 = Integer.parseInt(time1.substring(0, 2))*60;
		int minute1 = Integer.parseInt(time1.substring(3, 5));
		int hour2 = Integer.parseInt(time2.substring(0, 2))*60;
		int minute2 = Integer.parseInt(time2.substring(3, 5));
		
		int time1Aux =hour1+minute1;
		int time2Aux =hour2+minute2;
		
		if(time1Aux>time2Aux)
			return true;
		
		return false;

	}

}
