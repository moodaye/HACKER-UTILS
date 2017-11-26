package com.moodaye.utils.lambdas;

import java.util.Arrays;
import java.util.Optional;

public class Lambdas1 {

	/** returns longest string in sentence.  If there are equals strings - returns 
	 * string that is alphabetically largest.
	 */
	public static String longestStringInSentence(String sentence){
		Optional<String> max = Arrays.asList(sentence.split("\\s")).stream().max((String s1, String s2) -> {
			return s1.length() == s2.length() ? s2.compareTo(s1) : s1.length() - s2.length();
		});
		return max.orElse("");
	}
}
