package ua.kud.neetcode.leetcode.arrays;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidAnagramTest {

	@Test
	public void test() {
		ValidAnagram s = new ValidAnagram();
		assertCases(s::isAnagramSolveBySort);
		assertCases(s::isAnagramSolveByMap);
	}

	private void assertCases(IsAnagramFunction f) {
		assertTrue(f.isAnagram("anagram", "nagaram"));
		assertTrue(!f.isAnagram("rat", "car"));
		assertTrue(f.isAnagram("anagramanagram", "nagaramnagaram"));
	}

}
