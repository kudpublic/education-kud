package ua.kud;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void test() {
		int[] input = new int[] { 1, 2, 3, 4, 1, 2, 8, 3, 9, 5, 11, 10 };
		new MergeSort().sort(input);
		printArray(input);
	}

	private void printArray(int[] input) {
		Arrays.stream(input).forEach(i -> System.out.print(i + " "));
	}

}
