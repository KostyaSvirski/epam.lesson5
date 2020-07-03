package by.svirski.lesson5.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.svirski.lesson5.exception.ProjectStringsException;
import by.svirski.lesson5.service.TasksInterface;
import by.svirski.lesson5.validator.impl.ValidateStringInputImpl;

public class ServiceOnRegexpImpl implements TasksInterface<String> {

	private static final String CONSONANTS = "qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNMйцкнгшщзхфвпрлджчсмтбЙЦКНГШЩЗХФВПРЛДЖЧСМТЬБ";
	private static final String WORD_GIVEN_LENGTH = "\\b\\p{L}{%length}\\b";
	private static final String LETTER_ON_GIVEN_POSITION = "\\b(\\p{L}{%position})(\\p{L})(\\p{L}*)";
	private static final String ERROR_TO_CORRECT = "(\\p{L}*)(ра|РА)(\\p{L}*)";
	private static final String REPLACEMENET_GROUP = "$1%group$3";
	private static final String REMOVE_NOT_LETTER_SPACE = "[^\\p{L}\\s]";
	private static final String REMOVE_WORD_CONSONANTS_LENGTH = "\\b(\\p{L})\\p{L}{%length}\\b";

	private static ValidateStringInputImpl validatorStrings = new ValidateStringInputImpl();

	@Override
	public String changeSymbolInLine(String str, int positionOfSymbol, char newSymbol) throws ProjectStringsException {
		if (validatorStrings.validateValues(str, positionOfSymbol, newSymbol)) {
			Pattern pattern = Pattern.compile(String.format(LETTER_ON_GIVEN_POSITION, positionOfSymbol - 1));
			Matcher matcher = pattern.matcher(str);
			String resultString = matcher.replaceAll(String.format(REPLACEMENET_GROUP, newSymbol));
			return resultString;
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String errorCorrection(String str) throws ProjectStringsException {
		if(validatorStrings.validateValues(str)) {
			Pattern pattern = Pattern.compile(ERROR_TO_CORRECT);
			Matcher matcher = pattern.matcher(str);
			String resultString = matcher.replaceAll(String.format(REPLACEMENET_GROUP, "ра"));
			return resultString;			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String changeOnSubstr(String str, String substring, int lengthOfWord) throws ProjectStringsException {
		if (validatorStrings.validateValues(str, substring, lengthOfWord)) {
			Pattern pattern = Pattern.compile(String.format(WORD_GIVEN_LENGTH, lengthOfWord));
			Matcher matcher = pattern.matcher(str);
			String resultString = matcher.replaceAll(substring);
			return resultString;			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String deleteNotLetterSymbols(String str) throws ProjectStringsException {
		if(validatorStrings.validateValues(str)) {
			Pattern pattern = Pattern.compile(REMOVE_NOT_LETTER_SPACE);
			Matcher matcher = pattern.matcher(str);
			String resultString = matcher.replaceAll(" ");
			return resultString;			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

	@Override
	public String deleteWordsGivenLengths(String str, int length) throws ProjectStringsException {
		if (validatorStrings.validateValues(str, length)) {
			Pattern pattern = Pattern.compile(String.format(REMOVE_WORD_CONSONANTS_LENGTH, length - 1));
			Matcher matcher = pattern.matcher(str);
			while (matcher.find()) {
				if (CONSONANTS.contains(matcher.group(1))) {
					str = matcher.replaceAll("");
				}
			}
			return str;			
		} else {
			throw new ProjectStringsException("Invalid input");
		}
	}

}
