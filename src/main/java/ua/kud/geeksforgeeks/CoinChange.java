package ua.kud.geeksforgeeks;

public class CoinChange {
	public static void main(String[] args) {
		System.out.println(countR(new int[] { 3, 1, 2 }, 3, 4));
		System.out.println(countD(new int[] { 3, 1, 2 }, 3, 4));

		System.out.println(countD(new int[] { 89, 62, 82, 87, 88, 53, 29, 16, 50, 95, 70, 32, 17, 57, 3, 61, 44, 91, 24,
				72, 94, 34, 90, 52, 7, 65, 22, 15, 92, 38, 60, 63, 78, 64, 55, 36, 46, 85, 30, 11, 12, 33, 96, 45, 13,
				4, 98, 40, 93, 83, 1, 42 }, 52, 432));
	}

	/* countD - count dynamic */
	private static long countD(int[] coins, int numberOfCoins, int sum) {
		long[] dp = new long[sum + 1];
		dp[0] = 1;
		for (int i = 0; i < numberOfCoins; i++) {
			int coin = coins[i];
			for (int currentSum = 1; currentSum <= sum; currentSum++) {
				if (coin <= currentSum) {
					if (currentSum - coin >= 0) {
						dp[currentSum] = dp[currentSum] + dp[currentSum - coin];
					}
				}
			}
		}

		return dp[sum];
	}

	/* countR - count recursively */
	public static int countR(int coins[], int numberOfCoins, int sum) {
		return countR(coins, 0, 0, sum);
	}

	public static int countR(int coins[], int i, int currentSum, int goalSum) {

		if (i >= coins.length || currentSum > goalSum) {
			return 0;
		}

		if (currentSum == goalSum) {
			return 1;
		}

		return countR(coins, i, currentSum + coins[i], goalSum) + countR(coins, i + 1, currentSum, goalSum);
	}

}
