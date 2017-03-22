package com.moodaye.utils.algorithms.bitManipulation;

import java.io.PrintWriter;
import java.util.Scanner;

public class CountingSetBitsInRange {
	public static void main(String args[]) {
		new CountingSetBitsInRange().run();
	}

	void run() {
		try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
			solve(in, out);
		}
	}

	void solve(Scanner in, PrintWriter out) {
		int n = in.nextInt();
		System.out.println(countSetBits1toN_R(n));
		System.out.println(countSetBits1toNcf(n));
	}

	/**
	 * Uses recursion and division by 2 to count set bits Performance complexity
	 * = O(NlogN)
	 */
	public static int countSetBitsR(int n) {
		if (n <= 0)
			return 0;
		int cnt = 0;
		return (n % 2 == 0 ? 0 : 1) + countSetBitsR(n / 2);
	}

	/** Brute force counting of set bits */
	public static int countSetBitsBf(int n) {
		int cnt = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				cnt++;
			n >>= 1;
		}
		return cnt;
	}

	/**
	 * Returns number of set bits from 1 to n. Brute force Can use either the
	 * recursive or bf method - both will be slow for large n
	 */
	public static int countSetBits1toN_R(int n) {
		int cnt = 0;
		while (n > 0) {
			int c = countSetBitsR(n--);
			cnt += c;
		}
		return cnt;
	}

	/**
	 * Semi closed form method for counting set bits There should be a fully
	 * closed form method to do this Realizes that there is a simple pattern for
	 * counting set bits from 1 to n if n is of the form 2^k - 1 (e.g., 7) Total
	 * set bits (1 .. n) = k*(2^(k-1))
	 * 
	 * Given a number n - reduce it to the form 2^k - 1 and the larger portion
	 * that remains.
	 */
	public static int countSetBits1toNcf(int n) {
		int temp = n;
		int leftMostBit = 0;
		while (temp > 1) {
			temp >>= 1;
			leftMostBit++;
		}
		return recursiveBitCf(n, leftMostBit);

	}

	/** helper function, n is the original number */
	private static int recursiveBitCf(int n, int leftMostBit) {
		if (n == 0)
			return 0;

		int nextLeftMostBit = leftMostBit;
		int temp = 1 << leftMostBit;
		while (n < temp) {
			temp >>= 1;
			nextLeftMostBit--;
		}

		// if n is of the form 1.* (e.g. n = 7 ---> 111)
		// .... then use formula
		if (n == (1 << ((nextLeftMostBit + 1))) - 1)
			return ((nextLeftMostBit + 1) * (1 << nextLeftMostBit));

		n -= (1 << nextLeftMostBit);
		return (n + 1) + countSetBits1toN_R(n) + nextLeftMostBit * (1 << (nextLeftMostBit - 1));
	}
}
