package ua.kud.neetcode.leetcode.arrays;

/**
<p>
217. Contains Duplicate
<p>
https://leetcode.com/problems/contains-duplicate/ 
<p>
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

<p>
Example 1:
<p>
Input: nums = [1,2,3,1]
Output: true
<p>
Example 2:
<p>
Input: nums = [1,2,3,4]
Output: false
<p>
Example 3:
<p>
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 
<p>
Constraints:
<p>
1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public String print(String s) {
		return null;
	};

	public boolean containsDuplicateSolveBySort(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i]) {
				return true;
			}
		}
		return false;
	}

	public boolean containsDuplicateSolveByMap(int[] nums) {
		Set<Integer> set  = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}

}

@FunctionalInterface
interface ContainsDuplicateFunction {
	boolean containsDuplicate(int[] nums);
}
