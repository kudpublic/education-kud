package ua.kud.neetcode.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
	
	public boolean isValidSudoku(char[][] board) {
		
		Map<String, Set<Character>> validationGroup = new HashMap<String, Set<Character>>();
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				String rowMapKey = "r" + row;
				if (!check(getValidationMap(validationGroup, rowMapKey), board[row][col])) {
					return false;
				}
				String colMapKey = "c" + col;
				if (!check(getValidationMap(validationGroup, colMapKey), board[row][col])) {
					return false;
				}
				String blockMapKey = "b" + row / 3 + "" + col / 3;
				if (!check(getValidationMap(validationGroup, blockMapKey), board[row][col])) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean check(Set<Character> validationMap, char c) {
		if (c == '.') {
			return true;
		}
		if (validationMap.contains(c)) {
			return false;
		}
		validationMap.add(c);
		return true;
	}

	private Set<Character> getValidationMap(Map<String, Set<Character>> validationGroup, String key) {
		Set<Character> validationMap = validationGroup.get(key);
		if (validationMap == null) {
			validationMap = new HashSet<Character>();
			validationGroup.put(key, validationMap);
		}
		return validationMap;
	}
}
