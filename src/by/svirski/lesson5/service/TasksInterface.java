package by.svirski.lesson5.service;

public interface TasksInterface<T> {
	
	public T changeSymbolInLine(T str, int positionOfSymbol, char newSymbol);
	public T errorCorrection(T str);
	public T changeOnSubstr(T str, String substring, int lengthOfWord);
	public T deleteNotLettersSymbols(T str);
	public T deleteWordsGivenLengths(T str, int length);
	
}
