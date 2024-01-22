package ua.kud.neetcode.leetcode.arrays;

import org.junit.Test;

import ua.kud.neetcode.leetcode.arrays.TopKFrequentElements.TopKFrequentElementsFunction;

public class TopKFrequentElementsTest {

	@Test
	public void test() {
		TopKFrequentElements t = new TopKFrequentElements();
		System.out.println("S1:");
		test(t::topKFrequentS1);
		System.out.println("\nS2:");
		test(t::topKFrequentS2);
	}
	
	private void test(TopKFrequentElementsFunction func) {
		print(func.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
		print(func.topKFrequent(new int[] { 1 }, 1));
		print(func.topKFrequent(new int[] { 1, 1 }, 1));
		print(func.topKFrequent(new int[] { -1, -1 }, 1));
		print(func.topKFrequent(new int[] { 1, 2 }, 2));
	}

	private void print(int[] topKFrequent) {
		for (int i = 0; i < topKFrequent.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(topKFrequent[i]);
		}
		System.out.println("");
	}

}
