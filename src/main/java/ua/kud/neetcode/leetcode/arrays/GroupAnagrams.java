package ua.kud.neetcode.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * <p>
 * https://leetcode.com/problems/group-anagrams/
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * <p>
 * 
 * 
 * Example 1:
 * <p>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * <p>
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Example 2:
 * <p>
 * 
 * Input: strs = [""]
 * <p>
 * Output: [[""]]
 * <p>
 * Example 3:
 * <p>
 * Input: strs = ["a"]
 * <p>
 * Output: [["a"]]
 * <p>
 * 
 * Constraints:
 * <p>
 * 1 <= strs.length <= 104
 * <p>
 * 0 <= strs[i].length <= 100
 * <p>
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagramsByArray(String[] input) {
		Map<String, List<String>> anagramGroupMap = new HashMap<String, List<String>>();
		for (int i = 0; i < input.length; i++) {
			String anagramGroupElement = input[i];
			int[] hash = new int[26];
			for (int j = 0; j < anagramGroupElement.length(); j++) {
				hash[anagramGroupElement.charAt(j) - 'a']++;
			}
			String key = Arrays.toString(hash);
			List<String> anagramGroup = anagramGroupMap.get(key);
			if (anagramGroup == null) {
				anagramGroup = new ArrayList<String>();
				anagramGroupMap.put(key, anagramGroup);
			}
			anagramGroup.add(anagramGroupElement);
		}
		List<List<String>> anagramGroupList = new ArrayList<List<String>>();
		anagramGroupList.addAll(anagramGroupMap.values());
		return anagramGroupList;

	}

	public List<List<String>> groupAnagramsBySort(String[] input) {
		Map<String, List<String>> anagramGroupMap = new HashMap<String, List<String>>();
		for (int i = 0; i < input.length; i++) {
			String anagramGroupElement = input[i];

			String anagramGroupElementSorted = sort(anagramGroupElement);
			List<String> anagramGroup = anagramGroupMap.get(anagramGroupElementSorted);

			if (anagramGroup == null) {
				anagramGroup = new ArrayList<String>();
				anagramGroupMap.put(anagramGroupElementSorted, anagramGroup);
			}
			anagramGroup.add(anagramGroupElement);
		}
		List<List<String>> anagramGroupList = new ArrayList<List<String>>();
		anagramGroupList.addAll(anagramGroupMap.values());
		return anagramGroupList;
	}

	private String sort(String anagramGroupValue) {
		return anagramGroupValue.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

}

@FunctionalInterface
interface GroupAnagramsFunction {
	public List<List<String>> groupAnagrams(String[] input);
}
