class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];

        // Use -INF to mark unreachable states
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                java.util.Arrays.fill(dp[i][j], Integer.MIN_VALUE / 2);

        // cost and score for start cell (always 0 per constraints)
        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = grid[i][j];
                int score = val;
                int cost = (val == 0 ? 0 : 1);

                for (int used = cost; used <= k; used++) {

                    int best = Integer.MIN_VALUE / 2;

                    // from top
                    if (i > 0 && dp[i - 1][j][used - cost] > best) {
                        best = dp[i - 1][j][used - cost];
                    }
                    // from left
                    if (j > 0 && dp[i][j - 1][used - cost] > best) {
                        best = dp[i][j - 1][used - cost];
                    }

                    // starting cell case (0,0) already initialized

                    dp[i][j][used] = Math.max(dp[i][j][used], best + score);
                }
            }
        }

        // Take best score at (m-1,n-1) with cost <= k
        int ans = -1;
        for (int used = 0; used <= k; used++) {
            ans = Math.max(ans, dp[m - 1][n - 1][used]);
        }
        return ans < 0 ? -1 : ans;
    }
}
