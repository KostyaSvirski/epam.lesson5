package by.svirski.lesson5.service.impl;

import by.svirski.lesson5.service.TasksInterface;

public class ServiceOnCharSequences implements TasksInterface<char[]> {

	@Override
	public char[] changeSymbolInLine(char[] str, int positionOfSymbolChange, char newSymbol) {
		int currentPositionSymbolWord = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				currentPositionSymbolWord = 0;
			} else if (currentPositionSymbolWord == positionOfSymbolChange) {
				str[i] = newSymbol;
			}
		}
		return str;
	}

	@Override
	public char[] errorCorrection(char[] str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'Р' && str[i + 1] == 'А') {
				str[i + 1] = 'О';
				i++;
			}
		}
		return str;
	}

	@Override
	public char[] changeOnSubstr(char[] str, String substring, int lengthOfWord) {
		int checkedWordLength = 0;
		char[] resultStr = new char[str.length + 100];
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				if (lengthOfWord == checkedWordLength) {
					resultStr = replaceWord(substring, str, resultStr, i);
				} else {
					resultStr = placeCheckedWord(str, resultStr, i);
				}
				checkedWordLength = 0;
			} else {
				checkedWordLength += 1;
			}
		}
		return resultStr;
	}

	private char[] placeCheckedWord(char[] str, char[] resultStr, int i) {
		//TODO think how to reduce the number of variables
		return null;
	}

	private char[] replaceWord(String substring, char[] str, char[] resultStr, int i) {
		//TODO think how to reduce the number of variables
		return null;
	}

	@Override
	public char[] deleteNotLettersSymbols(char[] str) {
		//TODO 
		return null;
	}

	@Override
	public char[] deleteWordsGivenLengths(char[] str, int length) {
		//TODO
		return null;
	}

}
