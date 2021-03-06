package by.svirski.lesson5.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.svirski.lesson5.exception.ProjectStringsException;
import by.svirski.lesson5.service.TasksInterface;
import by.svirski.lesson5.validator.impl.ValidateStringInputImpl;

public class ServiceOnRegexpImpl implements TasksInterface<String> {

	private static final String CONSONANTS = "qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNMйцкнгшщзхфвпрлджчсмтбЙЦКНГШЩЗХФВПРЛДЖЧСМТЬБ";
	private static final String WORD_GIVEN_LENGTH = "\\b\\p{L}{%d}\\b";
	private static final String LETTER_ON_GIVEN_POSITION = "\\b(\\p{L}{%d})(\\p{L})(\\p{L}*)";
	private static final String ERROR_TO_CORRECT = "(\\p{L}*)(PA|pa)(\\p{L}*)";
	private static final String REPLACEMENET_GROUP = "$1%s$3";
	private static final String REMOVE_NOT_LETTER_SPACE = "[^\\p{L}\\s]";
	private static final String REMOVE_WORD_CONSONANTS_LENGTH = "\\b(\\p{L})\\p{L}{%d}\\b";

	private static ValidateStringInputImpl validatorStrings = new ValidateStringInputImpl();

	@Override
	public String changeSymbolInLine(String textInput, int positionOfSymbol, char newSymbol) throws ProjectStringsException {
		if (validatorStrings.validateValues(textInput, positionOfSymbol, newSymbol)) {
			Pattern pattern = Pattern.compile(String.format(LETTER_ON_GIVEN_POSITION, positionOfSymbol - 1));
			Matcher matcher = pattern.matcher(textInput);
			String resultString = matcher.replaceAll(String.format(REPLACEMENET_GROUP, newSymbol));
			return resultString;
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String errorCorrection(String textInput) throws ProjectStringsException {
		if(validatorStrings.validateValues(textInput)) {
			Pattern pattern = Pattern.compile(ERROR_TO_CORRECT);
			Matcher matcher = pattern.matcher(textInput);
			String resultString = matcher.replaceAll(String.format(REPLACEMENET_GROUP, "po"));
			return resultString;			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String changeOnSubstr(String textInput, String substring, int lengthOfWord) throws ProjectStringsException {
		if (validatorStrings.validateValues(textInput, substring, lengthOfWord)) {
			Pattern pattern = Pattern.compile(String.format(WORD_GIVEN_LENGTH, lengthOfWord));
			Matcher matcher = pattern.matcher(textInput);
			String resultString = matcher.replaceAll(substring);
			return resultString;			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String deleteNotLetterSymbols(String textInput) throws ProjectStringsException {
		if(validatorStrings.validateValues(textInput)) {
			Pattern pattern = Pattern.compile(REMOVE_NOT_LETTER_SPACE);
			Matcher matcher = pattern.matcher(textInput);
			String resultString = matcher.replaceAll(" ");
			return resultString;			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String deleteWordsGivenLengths(String textInput, int length) throws ProjectStringsException {
		if (validatorStrings.validateValues(textInput, length)) {
			Pattern pattern = Pattern.compile(String.format(REMOVE_WORD_CONSONANTS_LENGTH, length - 1));
			Matcher matcher = pattern.matcher(textInput);
			while (matcher.find()) {
				if (CONSONANTS.contains(matcher.group(1))) {
					textInput = matcher.replaceAll("");
				}
			}
			return textInput;			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

}
