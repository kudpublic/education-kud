package ua.kud.neetcode.leetcode.arrays;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class GroupAnagramsTest {

	@Test
	public void test() {
		GroupAnagrams solution = new GroupAnagrams();
		testCases(solution::groupAnagramsBySort);
		testCases(solution::groupAnagramsByArray);
	}

	private void testCases(GroupAnagramsFunction f) {
		check(new String[][] { { "bat" }, { "nat", "tan" }, { "ate", "eat", "tea" } }, f.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		check(new String[][] { { "" } }, f.groupAnagrams(new String[] { "" }));
		check(new String[][] { { "", "", "" } }, f.groupAnagrams(new String[] { "", "", "" }));
		check(new String[][] { { "a" } }, f.groupAnagrams(new String[] { "a" }));

	}

	private void check(String[][] expectedGroups, List<List<String>> actualGroups) {
		sort(expectedGroups);
		compare(expectedGroups, sort(actualGroups));

	}

	private void compare(String[][] expectedGroups, String[][] actualGroups) {

		assertEquals(expectedGroups.length, actualGroups.length);

		for (int i = 0; i < actualGroups.length; i++) {
			String[] expectedRow = expectedGroups[i];
			String[] actualRow = actualGroups[i];

			assertEquals(expectedRow.length, actualRow.length);

			for (int j = 0; j < actualRow.length; j++) {
				assertEquals(expectedRow[j], actualRow[j]);
			}
		}

	}

	private String[][] sort(List<List<String>> actual) {
		String[][] local = new String[actual.size()][];
		for (int i = 0; i < actual.size(); i++) {
			String[] row = new String[actual.get(i).size()];
			for (int j = 0; j < actual.get(i).size(); j++) {
				row[j] = actual.get(i).get(j);
			}
			local[i] = row;
		}
		sort(local);
		return local;
	}

	private void sort(String[][] groups) {
		for (int i = 0; i < groups.length; i++) {
			Arrays.sort(groups[i]);
		}
		Arrays.sort(groups, new Comparator<String[]>() {
			@Override
			public int compare(String[] group1, String[] group2) {
				return group1[0].compareTo(group2[0]);
			}
		});
	}
}
