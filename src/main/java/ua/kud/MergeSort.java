package ua.kud;

public class MergeSort {

	public void sort(int[] input) {

		if (input.length <= 3) {
			bubbleSort(input);
			return;
		}

		int middle = input.length / 2;
		int[] leftSubarray = new int[middle];

		int rightSubarrayLen = middle;
		if (input.length % 2 != 0) {
			rightSubarrayLen++;
		}
		int[] rightSubarray = new int[rightSubarrayLen];
		System.arraycopy(input, 0, leftSubarray, 0, leftSubarray.length);
		System.arraycopy(input, middle, rightSubarray, 0, rightSubarray.length);

		sort(leftSubarray);
		sort(rightSubarray);

		merge(input, leftSubarray, rightSubarray);
	}

	private void merge(int[] input, int[] leftSubarray, int[] rightSubarray) {
		int left = 0;
		int right = 0;
		for (int i = 0; i < input.length; i++) {
			if (left == leftSubarray.length) {
				input[i] = rightSubarray[right];
				right++;
				continue;
			}
			if (right == rightSubarray.length) {
				input[i] = leftSubarray[i];
				left++;
				continue;
			}
			if (leftSubarray[left] > rightSubarray[right]) {
				input[i] = rightSubarray[right];
				right++;
			} else {
				input[i] = leftSubarray[left];
				left++;
			}
		}

	}

	private void bubbleSort(int[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length - i - 1; j++) {
				if (input[j] > input[j + 1]) {
					swap(input, j, j + 1);
				}
			}
		}
	}

	private void swap(int[] input, int i1, int i2) {
		int tmp = input[i1];
		input[i1] = input[i2];
		input[i2] = tmp;
	}

}
