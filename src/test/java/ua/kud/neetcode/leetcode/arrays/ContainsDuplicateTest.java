package ua.kud.neetcode.leetcode.arrays;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ContainsDuplicateTest {

	@Test
	public void test() {
		ContainsDuplicate s = new ContainsDuplicate();
		assertCases(s::containsDuplicateSolveBySort);
		assertCases(s::containsDuplicateSolveByMap);
	}

	private void assertCases(ContainsDuplicateFunction func) {
		assertTrue(!func.containsDuplicate(new int[] { 1, 2, 3, 4, 5 }));
		assertTrue(func.containsDuplicate(new int[] { 1, 2, 3, 4, 1 }));
		assertTrue(func.containsDuplicate(new int[] { 1, 2, 3, 4, 4 }));
		assertTrue(func.containsDuplicate(new int[] { 1, 2, 3, 3, 4 }));
		assertTrue(!func.containsDuplicate(new int[] { 1, 2, 3, 5, 4, 6, 7, 8, 9, 10 }));
		assertTrue(func.containsDuplicate(new int[] { 1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 1, 2, 3, 5, 4, 6, 7, 8, 9, 10 }));
	}

}
