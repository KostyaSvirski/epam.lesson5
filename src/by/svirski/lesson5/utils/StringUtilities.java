package by.svirski.lesson5.utils;

public class StringUtilities {

	public static String transformToString(String[] strArray) {
		StringBuilder builder = new StringBuilder();
		for(String tempStr : strArray) {
			builder.append(tempStr);
			builder.append(" ");
		}
		return builder.toString();		
	}

}
