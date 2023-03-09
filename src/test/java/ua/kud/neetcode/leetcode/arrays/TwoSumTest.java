package ua.kud.neetcode.leetcode.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TwoSumTest {

	@Test
	public void test() {
		TwoSum s = new TwoSum();
		testCases(s::twoSumSolveByMap);
		testCases(s::twoSumSolveByBruteForce);
	}

	private void testCases(TwoSumFunction f) {
		assertEquals("[0,1]", print(f.twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		assertEquals("[1,2]", print(f.twoSum(new int[] { 3, 2, 4 }, 6)));
		assertEquals("[0,1]", print(f.twoSum(new int[] { 3, 3 }, 6)));
	}

	private Object print(int[] ar) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < ar.length; i++) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append(ar[i]);
		}
		sb.append("]");
		return sb.toString();
	}

}
