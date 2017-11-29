package com.moodaye.utils.lambdas;

import java.util.stream.IntStream;

public class Lambda1 {

	/** returning a stream of char integers from a String */
	/*  chars is derived from CharSequence interface */
	public static IntStream streamCharIntFromString(String s){
		return s.chars();
	}

}
