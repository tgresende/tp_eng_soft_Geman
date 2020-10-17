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
}
