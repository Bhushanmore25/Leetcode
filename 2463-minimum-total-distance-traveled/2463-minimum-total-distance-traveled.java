class Solution {

    long[][] dp;

    public long solve(int i, int j, List<Integer> robots, List<Integer> factories) {
        
        if (i == robots.size()) return 0;

        if (j == factories.size()) return (long)1e15;

        if (dp[i][j] != -1) return dp[i][j];

        long skip = solve(i, j + 1, robots, factories);

        long use = Math.abs(robots.get(i) - factories.get(j))
                 + solve(i + 1, j + 1, robots, factories);

        return dp[i][j] = Math.min(skip, use);
    }

    public long minimumTotalDistance(List<Integer> r, int[][] f) {

        Collections.sort(r);
        Arrays.sort(f, (a, b) -> a[0] - b[0]);

        List<Integer> factories = new ArrayList<>();
        for (int[] factory : f) {
            for (int i = 0; i < factory[1]; i++) {
                factories.add(factory[0]);
            }
        }

        int n = r.size();
        int m = factories.size();

        dp = new long[n][m];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, r, factories);
    }
}

// class Solution {
//     public long minimumTotalDistance(List<Integer> r, int[][] f) {

//         // Step 1: sort
//         Collections.sort(r);
//         Arrays.sort(f, (a, b) -> a[0] - b[0]);

//         // Step 2: expand factories based on capacity
//         List<Integer> factories = new ArrayList<>();
//         for (int[] factory : f) {
//             for (int i = 0; i < factory[1]; i++) {
//                 factories.add(factory[0]);
//             }
//         }

//         int n = r.size();
//         int m = factories.size();

//         // Step 3: DP table
//         long[][] dp = new long[n + 1][m + 1];

//         for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);

//         // base case: 0 robots = 0 cost
//         for (int j = 0; j <= m; j++) dp[0][j] = 0;

//         // Step 4: DP transition
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {

//                 // skip this factory
//                 dp[i][j] = dp[i][j - 1];

//                 // use this factory
//                 if (dp[i - 1][j - 1] != Long.MAX_VALUE) {
//                     dp[i][j] = Math.min(dp[i][j],
//                             dp[i - 1][j - 1] + Math.abs(r.get(i - 1) - factories.get(j - 1)));
//                 }
//             }
//         }

//         return dp[n][m];
//     }
// }