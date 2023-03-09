package ua.kud.neetcode.leetcode.arrays;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 242. Valid Anagram
 * <p>
 * https://leetcode.com/problems/valid-anagram/
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram" Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car" Output: false
 * 
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * <p>
 * s and t consist of lowercase English letters.
 */

public class ValidAnagram {

	public boolean isAnagramSolveByArray(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] counter = new int[26];

		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}

		for (int n : counter) {
			if (n > 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnagramSolveBySort(String s, String t) {
		return sort(s).equals(sort(t));
	}

	private String sort(String s) {
		return s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

	public boolean isAnagramSolveByMap(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Long> sStat = getStat(s);
		Map<Character, Long> tStat = getStat(t);

		for (Character key : sStat.keySet()) {
			if (!sStat.get(key).equals(tStat.get(key))) {
				return false;
			}
		}
		return true;
	}

	private Map<Character, Long> getStat(String s) {
		return s.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	}
}

@FunctionalInterface
interface IsAnagramFunction {
	boolean isAnagram(String s, String t);
}
