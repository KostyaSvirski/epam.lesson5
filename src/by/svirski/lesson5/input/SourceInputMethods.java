package by.svirski.lesson5.input;

import java.io.IOException;
import java.util.List;

public interface SourceInputMethods<T> {
	
	public T consoleInput();
	public List<String> fileInput() throws IOException;
}
