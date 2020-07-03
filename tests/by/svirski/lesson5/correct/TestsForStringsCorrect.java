package by.svirski.lesson5.correct;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.*;

import by.svirski.lesson5.exception.ProjectStringsException;
import by.svirski.lesson5.service.impl.ServiceOnStringsImpl;

public class TestsForStringsCorrect {

	private ServiceOnStringsImpl service = new ServiceOnStringsImpl();

	@Test
	public void testChangeSymbolInLine() {
		try {
			String result = service.changeSymbolInLine("qwerty qwerty", 2, 'A');
			String expected = "qAerty qAerty";
			assertEquals(result, expected);
		} catch (ProjectStringsException e) {
			fail();
		}
	}

	@Test
	public void testErrorCorrection() {
		try {
			String result = service.errorCorrection("papo pa p a");
			String expected = "popo po p a";
			assertEquals(result, expected);
		} catch (ProjectStringsException e) {
			fail();
		}
	}
	
	@Test
	public void testChangeOnSubstr() {
		try {
			String result = service.changeOnSubstr("qwerty qwer q qwertyu", "AAA", 4);
			String expected = "qwerty AAA q qwertyu";
			assertEquals(result, expected);
		} catch (ProjectStringsException e) {
			fail();
		}
	}
	
	@Test
	public void testDeleteNotLetterSymbols() {
		try {
			String result = service.deleteNotLetterSymbols("qwerty, asdf / sdfgh.");
			String expected = "qwerty asdf  sdfgh";
			assertEquals(result, expected);
		} catch (ProjectStringsException e) {
			fail();
		}
	}
	
	@Test
	public void testDeleteWordsGivenLengths() {
		try {
			String result = service.deleteWordsGivenLengths("qwerty asdfff qwer", 6);
			String expected = "asdfff qwer ";
			assertEquals(result, expected);
		} catch (ProjectStringsException e) {
			fail();
		}
	}
}
