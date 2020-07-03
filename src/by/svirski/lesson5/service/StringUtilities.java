package by.svirski.lesson5.service;

public class StringUtilities {

	protected static final String ERROR_SEQUENCE = "РА";
	protected static final String CORRECT_SEQUENCE = "РО";
	protected static final String CONSONANTS = "(?:[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNMйцкнгшщзхфвпрлджчсмтбЙЦКНГШЩЗХФВПРЛДЖЧСМТЬБ])";
	protected static final String ANY_LETTER_AND_SPACE = "[A-Za-z ]";
	protected static final String NON_WORD_CHACRACTER = "\\b";
	
	protected static String transformToString(String[] strArray) {
		StringBuilder builder = new StringBuilder();
		for (String tempStr : strArray) {
			builder.append(tempStr);
			builder.append(" ");
		}
		return builder.toString();
	}

	protected static String transformToString(char[] sequence) {
		StringBuilder sb = new StringBuilder();
		for (char symbol : sequence) {
			sb.append(symbol);
		}
		return sb.toString();
	}

}
