package by.svirski.lesson5.source;

import java.io.IOException;

public interface SourceInputMethods<T> {
	
	public T consoleInput();
	public T fileInput() throws IOException;
}
