package by.svirski.lesson5.service;

import by.svirski.lesson5.exception.ProjectStringsException;

public interface TasksInterface<T> {

	T changeSymbolInLine(T str, int positionOfSymbol, char newSymbol) throws ProjectStringsException;

	T errorCorrection(T str) throws ProjectStringsException;

	T changeOnSubstr(T str, String substring, int lengthOfWord) throws ProjectStringsException;

	T deleteNotLetterSymbols(T str) throws ProjectStringsException;

	T deleteWordsGivenLengths(T str, int length) throws ProjectStringsException;

}
