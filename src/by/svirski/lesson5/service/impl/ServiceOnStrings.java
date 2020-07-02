package by.svirski.lesson5.service.impl;

import by.svirski.lesson5.service.TasksInterface;
import by.svirski.lesson5.utils.StringUtilities;

public class ServiceOnStrings implements TasksInterface<String> {

	public static final String ERROR_SEQUENCE = "РА";
	public static final String CORRECT_SEQUENCE = "РО";

	@Override
	public String changeSymbolInLine(String str, int positionOfSymbolChange, char newSymbol) {
		String[] strArray = str.split("\\W");
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].length() > positionOfSymbolChange) {
				strArray[i] = strArray[i].replace(strArray[i].charAt(positionOfSymbolChange), newSymbol);
			}
		}
		return StringUtilities.transformToString(strArray);
	}

	@Override
	public String errorCorrection(String str) {
		String strArray[] = str.split("\\W");
		for (String tempStr : strArray) {
			if (tempStr.indexOf(ERROR_SEQUENCE) != -1) {
				tempStr = tempStr.replace(ERROR_SEQUENCE, CORRECT_SEQUENCE);
			}
		}
		return StringUtilities.transformToString(strArray);
	}

	@Override
	public String changeOnSubstr(String str, String substring, int lengthOfWord) {
		String[] strArray = str.split("\\W");
		for (String tempStr : strArray) {
			if (tempStr.length() == lengthOfWord) {
				tempStr = substring;
			}
		}
		return StringUtilities.transformToString(strArray);
	}

	@Override
	public String deleteNotLettersSymbols(String str) { // check this
		String[] strArray = str.split("[A-Za-z ]");
		String result = StringUtilities.transformToString(strArray);
		return result;
	}

	@Override
	public String deleteWordsGivenLengths(String str, int lengthOfWord) {
		String[] strArray = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String tempStr : strArray) {
			if (!tempStr.substring(0, 1).matches("(?:[qwrtpsdfghjklzxcvbnm])") || tempStr.length() != lengthOfWord) {
				sb.append(tempStr);
				sb.append(" ");
			}
		}
		return sb.toString();
	}

}
