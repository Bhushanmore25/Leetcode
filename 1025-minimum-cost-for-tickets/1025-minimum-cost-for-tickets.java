class Solution {
    public static int dfs(int i, int[] dp, int[] costs, int[] days) {
        if (i == days.length) {
            return 0;
        }
        if (dp[i] != Integer.MAX_VALUE) {
            return dp[i];
        }

        int[] durations = {1, 7, 30}; 

        for (int d = 0; d < durations.length; d++) {
            int j = i;
            while (j < days.length && days[j] < days[i] + durations[d]) {
                j++;
            }
            dp[i] = Math.min(dp[i], costs[d] + dfs(j, dp, costs, days));
        }

        return dp[i];
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return dfs(0, dp, costs, days);
    }
}
