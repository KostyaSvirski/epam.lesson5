package by.svirski.lesson5.validator.impl;

import by.svirski.lesson5.validator.ValidateInput;

public class ValidateCharSequenceInputImpl implements ValidateInput<char[]> {

	@Override
	public boolean validateValues(char[] str, int position, char symbol) {
		if (str.length != 0 && str != null && position > 0 && symbol >= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validateValues(char[] str) {
		if(str.length!= 0 && str!=null) {
			return true;
		} else {
			return false;			
		}
	}

	@Override
	public boolean validateValues(char[] str, String substring, int length) {
		if(str.length != 0 && str != null && !substring.isEmpty() && length > 0) {
			return true;
		} else {
			return false;			
		}
	}

	@Override
	public boolean validateValues(char[] str, int length) {
		if(str.length != 0 && str != null && length > 0) {
			return true;
		} else {
			return false;			
		}
	}

}
