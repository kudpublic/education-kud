package ua.kud.neetcode.leetcode.arrays.ContainsDuplicate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution s = new Solution();
		assertTrue(!s.containsDuplicate(new int[] { 1, 2, 3, 4, 5 }));
		assertTrue(s.containsDuplicate(new int[] { 1, 2, 3, 4, 1 }));
		assertTrue(s.containsDuplicate(new int[] { 1, 2, 3, 4, 4 }));
		assertTrue(s.containsDuplicate(new int[] { 1, 2, 3, 3, 4 }));
		assertTrue(!s.containsDuplicate(new int[] { 1, 2, 3, 5, 4, 6, 7, 8, 9, 10 }));
		assertTrue(s.containsDuplicate(new int[] { 1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 1, 2, 3, 5, 4, 6, 7, 8, 9, 10 }));
	}

}
