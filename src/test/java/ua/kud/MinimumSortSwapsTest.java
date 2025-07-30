package ua.kud;

import org.junit.Test;

public class MinimumSortSwapsTest {

	@Test
	public void test() {
		System.out.println(new MinimumSortSwaps().calculateMinSwapsToSort(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(new MinimumSortSwaps().calculateMinSwapsToSort(new int[] { 2, 1 }));
		System.out.println(new MinimumSortSwaps().calculateMinSwapsToSort(new int[] { 2, 3, 1 }));
	}

}
