import java.util.*;

class Solution {
    static int mod = (int) 1e9 + 7;
    public static int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        for (int it : nums) {
            sum += it;
        }
        if (sum / 2 < k) return 0;

        Long[][] dp = new Long[n+1][10001];

        long num = solveWrong(nums, 0, k, 0, dp);
        long pow = 1;
        for (int i = 1; i <= n; i++) {
            pow = ((pow % mod) * 2) % mod;
        }
        long ans = ((pow - ((2 * num) % mod)) + mod) % mod;
        return (int) ans;
    }

    private static long solveWrong(int[] nums, int curSum, int k, int index, Long[][] dp) {
        if (index >= nums.length) {
            if (curSum < k) return 1;
            return 0;
        }
        if(dp[index][curSum] != null) return dp[index][curSum];

        long pick = 0;
        if (curSum + nums[index] < k) {
            pick = solveWrong(nums, curSum + nums[index], k, index + 1, dp) % mod;
        }
        long notPick = solveWrong(nums, curSum, k, index + 1, dp) % mod;
        return dp[index][curSum] = (pick + notPick) % mod;
    }
}
