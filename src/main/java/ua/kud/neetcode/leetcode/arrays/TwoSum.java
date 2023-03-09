package ua.kud.neetcode.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 1. Two Sum
 * <p>
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * <p>
 * Output: [0,1]
 * <p>
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * <p>
 * Output: [1,2]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * <p>
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 104
 * <p>
 * -109 <= nums[i] <= 109
 * <p>
 * -109 <= target <= 109
 * <p>
 * Only one valid answer exists.
 */

public class TwoSum {

	public int[] twoSumSolveByMap(int[] nums, int target) {
		Map<Integer, Integer> twoSumMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (twoSumMap.get(target - nums[i]) != null) {
				return new int[] { twoSumMap.get(target - nums[i]), i };
			}
			twoSumMap.put(nums[i], i);
		}
		return new int[0];
	}

	public int[] twoSumSolveByBruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[0];
	}
}

@FunctionalInterface
interface TwoSumFunction {
	int[] twoSum(int[] nums, int target);
}
