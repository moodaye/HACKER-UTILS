package com.moodaye.utils.lambdas;

import java.util.stream.IntStream;

public class Lambda1 {

	/** returning a stream of char integers from a String */
	/* chars is derived from CharSequence interface */
	public static IntStream streamCharIntFromString(String s) {
		return s.chars();
	}

	public static void findNUniqueIntsSumZero(int n) {
		IntStream.rangeClosed(0, n / 2).forEach(x -> {
			if (x == 0) {
				if (n % 2 == 1) {
					System.out.print(0 + " ");
				}
			} else {
				System.out.print(x + " " + -x + " ");
			}
		});
	}
}
