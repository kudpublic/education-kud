package ua.kud;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Coding Question: “Minimum Swaps to Sort an Array” Given an array of distinct
 * elements, return the minimum number of swaps required to sort the array.
 * 
 * This is a graph cycle detection problem disguised as an array question.
 * https://blog.stackademic.com/i-cracked-the-goldman-sachs-java-interview-heres-what-you-need-to-know-664da2073e1c
 */
public class MinimumSortSwaps {

	public int calculateMinSwapsToSort(int[] input) {

		int[][] valueIndexMapping = new int[input.length][2];
		for (int i = 0; i < input.length; i++) {
			int[] valueIndex = new int[2];
			valueIndex[0] = input[i];
			valueIndex[1] = i;
			valueIndexMapping[i] = valueIndex;
		}

		Arrays.sort(valueIndexMapping, Comparator.comparingInt(valueIndex -> valueIndex[0]));

		boolean[] visited = new boolean[input.length];

		int minSwaps = 0;

		for (int i = 0; i < input.length; i++) {

			if (visited[i] || valueIndexMapping[i][1] == i) {
				continue;
			}

			int sycleCount = 0;
			int sycleIndex = i;
			while (!visited[sycleIndex]) {
				visited[sycleIndex] = true;
				sycleIndex = valueIndexMapping[sycleIndex][1];
				sycleCount++;
			}

			minSwaps = minSwaps + (sycleCount - 1);
		}

		return minSwaps;
	}

}
