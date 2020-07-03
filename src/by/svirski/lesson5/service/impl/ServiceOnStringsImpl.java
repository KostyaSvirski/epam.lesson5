package by.svirski.lesson5.service.impl;

import by.svirski.lesson5.exception.ProjectStringsException;
import by.svirski.lesson5.service.StringUtilities;
import by.svirski.lesson5.service.TasksInterface;
import by.svirski.lesson5.validator.impl.ValidateStringInputImpl;

public class ServiceOnStringsImpl extends StringUtilities implements TasksInterface<String> {

	private static ValidateStringInputImpl validatorStrings = new ValidateStringInputImpl();

	@Override
	public String changeSymbolInLine(String str, int positionOfSymbolChange, char newSymbol)
			throws ProjectStringsException {
		if (validatorStrings.validateValues(str, positionOfSymbolChange, newSymbol)) {
			String[] strArray = str.split(NON_WORD_CHACRACTER);
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i].length() > positionOfSymbolChange) {
					strArray[i] = strArray[i].replace(strArray[i].charAt(positionOfSymbolChange-1), newSymbol);
				}
			}
			return transformToString(strArray);
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String errorCorrection(String str) throws ProjectStringsException {
		if (validatorStrings.validateValues(str)) {
			String strArray[] = str.split(NON_WORD_CHACRACTER);
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i].indexOf(ERROR_SEQUENCE) != -1) {
					strArray[i] = strArray[i].replace(ERROR_SEQUENCE, CORRECT_SEQUENCE);
				}
			}
			return transformToString(strArray);
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String changeOnSubstr(String str, String substring, int lengthOfWord) throws ProjectStringsException {
		if (validatorStrings.validateValues(str, substring, lengthOfWord)) {
			String[] strArray = str.split(NON_WORD_CHACRACTER);
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i].length() == lengthOfWord) {
					strArray[i] = substring;
				}
			}
			return transformToString(strArray);
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String deleteNotLetterSymbols(String str) throws ProjectStringsException {
		if (validatorStrings.validateValues(str)) {
			String[] strArray = str.split(ANY_LETTER_AND_SPACE);
			String result = transformToString(strArray);
			return result;
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String deleteWordsGivenLengths(String str, int lengthOfWord) throws ProjectStringsException {
		if (validatorStrings.validateValues(str, lengthOfWord)) {
			String[] strArray = str.split(" ");
			StringBuilder sb = new StringBuilder();
			for (String tempStr : strArray) {
				if (!tempStr.substring(0, 1).matches(CONSONANTS) || tempStr.length() != lengthOfWord) {
					sb.append(tempStr);
					sb.append(" ");
				}
			}
			return sb.toString();
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

}
