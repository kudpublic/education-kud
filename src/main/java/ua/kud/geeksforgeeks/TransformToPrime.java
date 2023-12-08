package ua.kud.geeksforgeeks;

import java.util.Arrays;

public class TransformToPrime {

	public static void main(String[] args) {
		System.out.println(minNumber(new int[] { 1, 0, 0 }, 3));
		System.out.println(minNumber(new int[] { 2, 4, 6, 8, 12 }, 5));
		System.out.println(minNumber(new int[] { 1, 5, 7 }, 3));
		System.out.println(minNumber(new int[] { 4 }, 1));
	}

	private static int minNumber(int arr[], int N) {
		int res = 0;

		int sum = Arrays.stream(arr).sum();
		while (!isPrime(sum + res)) {
			res++;
		}
		return res;
	}

	private static boolean isPrime(int val) {
		if (val <= 1) {
            return false;
        }
		for (int i = 2; i <= Math.sqrt(val); i++) {
			if (val % i == 0) {
				return false;
			}
		}
		return true;
	}

}
