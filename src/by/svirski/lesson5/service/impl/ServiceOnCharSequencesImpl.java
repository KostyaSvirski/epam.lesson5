package by.svirski.lesson5.service.impl;

import by.svirski.lesson5.exception.ProjectStringsException;
import by.svirski.lesson5.service.StringUtilities;
import by.svirski.lesson5.service.TasksInterface;
import by.svirski.lesson5.validator.impl.ValidateCharSequenceInputImpl;

public class ServiceOnCharSequencesImpl extends StringUtilities implements TasksInterface<char[]> {
	
	private static ValidateCharSequenceInputImpl validatorChar = new ValidateCharSequenceInputImpl();

	@Override
	public char[] changeSymbolInLine(char[] textInput, int positionOfSymbolChange, char newSymbol)
			throws ProjectStringsException {

		if (validatorChar.validateValues(textInput, positionOfSymbolChange, newSymbol)) {
			int currentPositionSymbolWord = 0;
			for (int i = 0; i < textInput.length; i++) {
				if (textInput[i] == ' ') {
					currentPositionSymbolWord = 0;
				} else if (currentPositionSymbolWord == positionOfSymbolChange) {
					textInput[i] = newSymbol;
				}
			}
			return textInput;
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public char[] errorCorrection(char[] textInput) throws ProjectStringsException {
		if(validatorChar.validateValues(textInput)) {
			for (int i = 0; i < textInput.length; i++) {
				if (textInput[i] == 'Р' && textInput[i + 1] == 'А') {
					textInput[i + 1] = 'О';
					i++;
				}
			}
			return textInput;			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public char[] changeOnSubstr(char[] str, String substring, int lengthOfWord) throws ProjectStringsException {
		if(validatorChar.validateValues(str, substring, lengthOfWord)) {
			String[] wordArray = transformToString(str).split(NON_WORD_CHACRACTER);
			for (String word : wordArray) {
				if (word.length() == lengthOfWord) {
					word = substring;
				}
			}
			return transformToString(wordArray).toCharArray();			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public char[] deleteNotLetterSymbols(char[] str) throws ProjectStringsException {
		if(validatorChar.validateValues(str)) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length; i++) {
				if (Character.isLetter(str[i]) || Character.isWhitespace(str[i])) {
					sb.append(str[i]);
				} else if (i - 1 >= 0 && i + 1 < str.length) {
					if (Character.isLetter(str[i - 1]) && Character.isLetter(str[i + 1])) {
						sb.append(' ');
					}
				}
			}
			return sb.toString().toCharArray();			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public char[] deleteWordsGivenLengths(char[] str, int length) throws ProjectStringsException {
		if(validatorChar.validateValues(str, length)) {
			StringBuilder sb = new StringBuilder();
			String[] wordArray = transformToString(str).split("\\W");
			for (String word : wordArray) {
				char[] charSequenceWord = word.toCharArray();
				if (charSequenceWord.length != length) {
					sb.append(word);
					sb.append(" ");
				} else {
					String symbolToCheck = Character.toString(charSequenceWord[0]);
					if (!symbolToCheck.matches(CONSONANTS)) {
						sb.append(word);
						sb.append(" ");
					}
				}
			}
			return sb.toString().toCharArray();
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

}
