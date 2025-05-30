package ua.kud.neetcode.leetcode.arrays;

/**
 * 238. Product of Array Except Self
 * 
 * <p>
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * <p>
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * <p>
 * Output: [24,12,8,6]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * <p>
 * Output: [0,0,9,0,0]
 * 
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 105
 * <p>
 * -30 <= nums[i] <= 30
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 * 
 *
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {

		int[] res = new int[nums.length];

		int prefixCursor = 1;
		res[0] = 1;
		int prefixBuffer = 1;

		int suffixCursor = nums.length - 2;
		res[nums.length - 1] = 1;
		int suffixBuffer = 1;

		int prefixCursorThreshold = nums.length / 2;

		int suffixCursorThreshold = prefixCursorThreshold;
		if (nums.length % 2 != 0) {
			suffixCursorThreshold = prefixCursorThreshold + 1;
		}

		while (suffixCursor >= 0) {
			int prefixProduct = prefixBuffer * nums[prefixCursor - 1];
			if (prefixCursor > (nums.length - 1) / 2) {
				res[prefixCursor] = res[prefixCursor] * prefixProduct;
			} else {
				res[prefixCursor] = prefixProduct;
			}
			prefixBuffer = prefixProduct;
			prefixCursor++;

			int suffixProduct = suffixBuffer * nums[suffixCursor + 1];
			if (suffixCursor < suffixCursorThreshold) {
				res[suffixCursor] = res[suffixCursor] * suffixProduct;
			} else {
				res[suffixCursor] = suffixProduct;
			}
			suffixBuffer = suffixProduct;
			suffixCursor--;
		}

		return res;
	}

	public int[] productExceptSelfEasy(int[] nums) {
		int[] res = new int[nums.length];

		int product = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res[i] = product;
			product *= nums[i];
		}

		res[0] = 1;
		product = nums[nums.length - 1];
		for(int i = nums.length - 2; i >= 0; i--) {
			res[i] *= product;
			product *= nums[i];
		}

		return res;
	}

	@FunctionalInterface
	interface ProductOfArrayExceptSelfFunction {
		public int[] productExceptSelf(int[] nums);
	}
}
