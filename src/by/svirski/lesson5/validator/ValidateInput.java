package by.svirski.lesson5.validator;

public interface ValidateInput<T> {
	
	boolean validateValues(T str, int position, char symbol);
	boolean validateValues(T str);
	boolean validateValues(T str, String substring, int length);
	boolean validateValues(T str, int length);

}
