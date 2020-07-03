package by.svirski.lesson5.validator.impl;

import by.svirski.lesson5.validator.ValidateInput;

public class ValidateStringInputImpl implements ValidateInput<String> {

	@Override
	public boolean validateValues(String str, int position, char symbol) {
		if (!str.isEmpty() && position > 0 && symbol >= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validateValues(String str) {
		if (!str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validateValues(String str, String substring, int length) {
		if (!str.isEmpty() && !substring.isEmpty() && length > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validateValues(String str, int length) {
		if(!str.isEmpty() && length > 0) {
			return true;
		} else {
			return false;			
		}
	}

}
