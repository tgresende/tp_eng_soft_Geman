package presentation;

public final class Utils {

	static String replaceCommaToDot(String word) {
		return word.replace(',','.');
	}
	
	static String onlyNumbers(String word) {
		String wordAux = word.replaceAll("\\D+","");
		if (wordAux.trim().equals(""))
			return "0";
		
		return wordAux;
	}
	
	static boolean isValidDate(String date) {	
		if (date.length() != 10)
			return false;
		
		int day = Integer.parseInt(onlyNumbers(date.substring(0, 2)));
		int month = Integer.parseInt(onlyNumbers(date.substring(3, 5)));
		int year = Integer.parseInt(onlyNumbers(date.substring(6, 10)));
		

		if (day > 31 || day < 1)
			return false;
		
		if (month > 12 || month < 1)
			return false; 
		
		if (year < 1900)
			return false;
		
		return true;
	}
	
	static boolean isValidTime(String time) {
		if (time.length() != 5)
			return false;
		
		int hour = Integer.parseInt(onlyNumbers(time.substring(0, 2)));
		int minute = Integer.parseInt(onlyNumbers(time.substring(3, 5)));
		

		if (hour > 23 || hour < 1)
			return false;
		
		if (minute > 60 || minute < 0)
			return false; 
		
		
		return true;
	}
	
}
