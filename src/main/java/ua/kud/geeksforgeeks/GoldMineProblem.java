package ua.kud.geeksforgeeks;

public class GoldMineProblem {
	public static void main(String[] args) {
		System.out.println(maxGold(3, 3, new int[][] { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } }));
		System.out.println(maxGold(4, 4, new int[][] { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } }));
		System.out.println(maxGold(1, 4, new int[][] { { 1, 3, 1, 5 } }));
		System.out.println(maxGold(4, 1, new int[][] { { 1 }, { 2 }, { 5 }, { 0 } }));
	}

	private static int maxGold(int n, int m, int M[][]) {

		for (int col = m - 2; col >= 0; col--) {
			for (int row = 0; row < n; row++) {
				// direction right
				int max = M[row][col + 1];

				// direction diagonal down
				if (row < n - 1) {
					if (M[row + 1][col + 1] > max) {
						max = M[row + 1][col + 1];
					}
				}

				// direction diagonal up
				if (row > 0) {
					if (M[row - 1][col + 1] > max) {
						max = M[row - 1][col + 1];
					}
				}

				M[row][col] += max;
			}
		}

		int max = 0;
		for (int row = 0; row < n; row++) {
			int amount = M[row][0];
			if (amount > max) {
				max = amount;
			}
		}

		return max;
	}

}
