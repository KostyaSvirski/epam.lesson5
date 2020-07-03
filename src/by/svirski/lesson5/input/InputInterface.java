package by.svirski.lesson5.input;

import java.io.IOException;
import java.util.List;

public interface InputInterface<T> {

	T consoleInput();

	List<String> fileInput() throws IOException;
}
