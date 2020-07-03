package by.svirski.lesson5.service.impl;

import by.svirski.lesson5.exception.ProjectStringsException;
import by.svirski.lesson5.service.StringUtilities;
import by.svirski.lesson5.service.TasksInterface;
import by.svirski.lesson5.validator.impl.ValidateStringInputImpl;

public class ServiceOnStringsImpl extends StringUtilities implements TasksInterface<String> {

	private static ValidateStringInputImpl validatorStrings = new ValidateStringInputImpl();

	@Override
	public String changeSymbolInLine(String textInput, int positionOfSymbolChange, char newSymbol)
			throws ProjectStringsException {
		if (validatorStrings.validateValues(textInput, positionOfSymbolChange, newSymbol)) {
			String[] wordArray = textInput.split(NON_WORD_CHACRACTER);
			for (int i = 0; i < wordArray.length; i++) {
				if (wordArray[i].length() > positionOfSymbolChange) {
					wordArray[i] = wordArray[i].replace(wordArray[i].charAt(positionOfSymbolChange-1), newSymbol);
				}
			}
			return transformToString(wordArray);
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String errorCorrection(String textInput) throws ProjectStringsException {
		if (validatorStrings.validateValues(textInput)) {
			String wordArray[] = textInput.split(NON_WORD_CHACRACTER);
			for (int i = 0; i < wordArray.length; i++) {
				if (wordArray[i].indexOf(ERROR_SEQUENCE) != -1) {
					wordArray[i] = wordArray[i].replace(ERROR_SEQUENCE, CORRECT_SEQUENCE);
				}
			}
			return transformToString(wordArray);
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String changeOnSubstr(String textInput, String substring, int lengthOfWord) throws ProjectStringsException {
		if (validatorStrings.validateValues(textInput, substring, lengthOfWord)) {
			String[] wordArray = textInput.split(NON_WORD_CHACRACTER);
			for (int i = 0; i < wordArray.length; i++) {
				if (wordArray[i].length() == lengthOfWord) {
					wordArray[i] = substring;
				}
			}
			return transformToString(wordArray);
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String deleteNotLetterSymbols(String textInput) throws ProjectStringsException {
		if (validatorStrings.validateValues(textInput)) {
			String[] wordArray = textInput.split(ANY_LETTER_AND_SPACE);
			String result = transformToString(wordArray);
			return result;
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String deleteWordsGivenLengths(String textInput, int lengthOfWord) throws ProjectStringsException {
		if (validatorStrings.validateValues(textInput, lengthOfWord)) {
			String[] wordArray = textInput.split(" ");
			StringBuilder sb = new StringBuilder();
			for (String tempStr : wordArray) {
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
