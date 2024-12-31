import java.util.*;

class Solution {
    public static int dfs(int amount, int[] coins, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1; 
        }
        if (dp[amount] != -2) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = dfs(amount - coin, coins, dp); 
            if (result != -1) { 
                minCoins = Math.min(minCoins, 1 + result);
            }
        }

        dp[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins; 
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return dfs(amount, coins, dp);
    }
}
