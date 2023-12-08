package ua.kud.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		print(sieveOfEratosthenes(10));
		print(sieveOfEratosthenes(25));
	}

	private static void print(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(list.get(i));
		}
		System.out.println("");
	}

	static ArrayList<Integer> sieveOfEratosthenes(int N) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);

		for (int i = 2; i * i <= N; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= N; j += i) {
					prime[j] = false;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (prime[i]) {
				res.add(i);
			}
		}

		return res;
	}
}
