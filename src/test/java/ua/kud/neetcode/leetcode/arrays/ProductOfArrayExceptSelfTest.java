package ua.kud.neetcode.leetcode.arrays;

import org.junit.Test;

import ua.kud.neetcode.leetcode.arrays.ProductOfArrayExceptSelf.ProductOfArrayExceptSelfFunction;

public class ProductOfArrayExceptSelfTest {

	@Test
	public void test() {
		test(new ProductOfArrayExceptSelf()::productExceptSelf);
	}

	private void test(ProductOfArrayExceptSelfFunction func) {
		print(func.productExceptSelf(new int[] { 1, 2, 3, 4 }));
		print(func.productExceptSelf(new int[] { 0, 2, 3, 0 }));
		print(func.productExceptSelf(new int[] { -1, 1, 0, -3, 3 }));

	}

	private void print(int[] res) {
		for (int i = 0; i < res.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(res[i]);
		}
		System.out.println("");
	}

}
