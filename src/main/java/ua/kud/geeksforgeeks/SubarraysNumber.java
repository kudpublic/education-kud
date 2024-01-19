package ua.kud.geeksforgeeks;

// https://www.geeksforgeeks.org/problems/number-of-subarrays-with-maximum-values-in-given-range5949/1
// Number of subarrays with maximum values in given range
public class SubarraysNumber {
	public static void main(String[] args) {
		System.out.println(countSubarrays(new int[] { 0, 0, 0, 0, 0 }, 5, 1, 10));
		System.out.println(countSubarrays(new int[] { 0, 0, 0, 1, 2 }, 5, 1, 10));
		System.out.println(countSubarrays(new int[] { 3, 4, 1, 5, 6, 11, 3 }, 7, 1, 10));

		System.out.println(countSubarrays(new int[] { 2, 0, 11, 3, 0 }, 5, 1, 10));
		System.out.println(countSubarrays(new int[] { 3, 4, 1 }, 3, 2, 4));
	}

	static long countSubarrays(int a[], int n, int L, int R) {
		long res = 0;

		// exc is going to store count of elements
		// smaller than L in current valid subarray.
		// inc is going to store count of elements
		// smaller than or equal to R.
		long exc = 0, inc = 0;

		// traverse through all elements of the array
		for (int i = 0; i < n; i++) {

			// If the element is greater than R,
			// add current value to result and reset
			// values of exc and inc.
			if (a[i] > R) {
				res += (countSubarrays(inc) - countSubarrays(exc));
				inc = 0;
				exc = 0;
			}

			// if it is less than L, then it is included
			// in the sub-arrays
			else if (a[i] < L) {
				exc++;
				inc++;
			}

			// if >= L and <= R, then count of
			// subarrays formed by previous chunk
			// of elements formed by only smaller
			// elements is reduced from result.
			else {
				res -= countSubarrays(exc);
				exc = 0;
				inc++;
			}
		}

		// Update result.
		res += (countSubarrays(inc) - countSubarrays(exc));

		// returns the count of sub-arrays
		return res;
	}

	static long countSubarrays(long n) {
		return n * (n + 1) / 2;
	}
}
