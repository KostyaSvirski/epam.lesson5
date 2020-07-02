package by.svirski.lesson5.exception;

public class ProjectStringsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ProjectStringsException() {

	}

	public ProjectStringsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectStringsException(Throwable cause) {
		super(cause);
	}

	public ProjectStringsException(String message) {
		super(message);
	}
	
}
