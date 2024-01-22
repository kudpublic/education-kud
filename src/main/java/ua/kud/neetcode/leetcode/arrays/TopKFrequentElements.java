package ua.kud.neetcode.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements
 * <p>
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * <p>
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * <p>
 * 
 * 
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * <p>
 * Output: [1,2]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * <p>
 * Output: [1]
 * <p>
 * 
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * <p>
 * -104 <= nums[i] <= 104
 * <p>
 * k is in the range [1, the number of unique elements in the array].
 * <p>
 * It is guaranteed that the answer is unique.
 * <p>
 */
public class TopKFrequentElements {

	public int[] topKFrequentS1(int[] nums, int k) {
		Map<Integer, Integer> valueCountMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (valueCountMap.get(nums[i]) != null) {
				valueCountMap.put(nums[i], valueCountMap.get(nums[i]) + 1);
			} else {
				valueCountMap.put(nums[i], 1);
			}
		}

		Map<Integer, List<Integer>> countValueMap = new HashMap<Integer, List<Integer>>();

		for (Integer val : valueCountMap.keySet()) {
			List<Integer> values = countValueMap.get(valueCountMap.get(val));
			if (values == null) {
				values = new ArrayList<Integer>();
				countValueMap.put(valueCountMap.get(val), values);
			}
			values.add(val);
		}

		List<Integer> result = new ArrayList<Integer>();

		for (int i = nums.length; i > 0; i--) {
			List<Integer> values = countValueMap.get(i);
			if (values != null) {
				for (int j = 0; j < values.size(); j++) {
					result.add(values.get(j));
					if (result.size() == k) {
						break;
					}
				}
			}
			if (result.size() == k) {
				break;
			}
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	/**
	 * Builds occurrences map of unique numbers
	 * 
	 * Partitions unique numbers array until there are k most frequent elements are
	 * in the end of the array
	 * 
	 **/
	public int[] topKFrequentS2(int[] nums, int k) {
		Map<Integer, Integer> valueCountMap = new HashMap<Integer, Integer>();
		Arrays.stream(nums).forEach(a -> valueCountMap.put(a, valueCountMap.getOrDefault(a, 0) + 1));

		int[] uniqueValues = new int[valueCountMap.size()];
		int idx = 0;
		for (int num : valueCountMap.keySet()) {
			uniqueValues[idx++] = num;
		}

		int left = 0;
		int right = uniqueValues.length - 1;

		int nSmallestElements = uniqueValues.length - k;
		int valueSortedIndex = 0;
		while (nSmallestElements != valueSortedIndex) {

			valueSortedIndex = partition(uniqueValues, valueCountMap, left, right);

			if (valueSortedIndex > nSmallestElements) {
				right = valueSortedIndex - 1;
			} else {
				left = valueSortedIndex + 1;
			}
		}

		return Arrays.copyOfRange(uniqueValues, uniqueValues.length - k, uniqueValues.length);
	}

	// Function which moves last element (right) to the position where all
	// elements to the right are bigger and all elements to the left are smaller
	private int partition(int[] unique, Map<Integer, Integer> valueCountMap, int left, int right) {
		int pivotCount = valueCountMap.get(unique[right]);

		int cursor = left;

		for (int i = left; i < right; i++) {
			int count = valueCountMap.get(unique[i]);
			if (count < pivotCount) {
				swap(unique, cursor, i);
				cursor++;
			}
		}

		swap(unique, cursor, right);

		return cursor;
	}

	private void swap(int[] unique, int cursor, int i) {
		int tmp = unique[cursor];
		unique[cursor] = unique[i];
		unique[i] = tmp;
	}

	@FunctionalInterface
	interface TopKFrequentElementsFunction {
		public int[] topKFrequent(int[] nums, int k);
	}
}
