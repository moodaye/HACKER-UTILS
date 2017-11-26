package com.moodaye.utils.lambdas;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.moodaye.utils.lambdas.Lambdas1.*;
public class Lambdas1Test {

	@Test
	public void testLongestStringInSentence() {
		assertEquals("Rajiv", longestStringInSentence("Rajiv Rajiv"));
		assertEquals("Rajiv", longestStringInSentence("Is Rajiv a fool?"));
		assertEquals("Rajiv", longestStringInSentence("Rajiv Rajiv fool?"));
		assertEquals("flowers", longestStringInSentence("Where have all the flowers gone?"));
	}
}
