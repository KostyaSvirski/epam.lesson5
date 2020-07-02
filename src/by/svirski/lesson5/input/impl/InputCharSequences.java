package by.svirski.lesson5.input.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import by.svirski.lesson5.input.SourceInputMethods;

public class InputCharSequences implements SourceInputMethods<char[]> {
	
	public static final String URI = "D:\\java\\EPAM\\svirski\\lesson5\\source.txt";

	@Override
	public char[] consoleInput() {
		Scanner scanner = new Scanner(System.in);
		String sourceString = scanner.nextLine();
		scanner.close();
		return sourceString.toCharArray();
	}

	@Override
	public List<String> fileInput() throws IOException {
		Path path = Paths.get(URI);
		List<String> lines = Files.readAllLines(path);
		return lines;
	}

}
