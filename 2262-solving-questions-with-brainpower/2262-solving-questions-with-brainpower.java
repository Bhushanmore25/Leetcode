import java.util.Arrays;

class Solution {
    // public static long recur(int[][] questions, long[] dp, int idx, int m) {
    //     if (idx >= m) {
    //         return 0L;
    //     }
    //     if (dp[idx] != -1) return dp[idx];

    //     long take = questions[idx][0] + recur(questions, dp, idx + questions[idx][1] + 1, m);
    //     long notTake = recur(questions, dp, idx + 1, m);
        
    //     return dp[idx] = Math.max(take, notTake);
    // }

    public long mostPoints(int[][] questions) {
        int m = questions.length;
        long[] dp = new long[m];
        Arrays.fill(dp, -1);

        for (int idx = m - 1; idx >= 0; idx--) 
        { 
            long take = questions[idx][0]; 
            if (idx + questions[idx][1] + 1 < m) { 
                take += dp[idx + questions[idx][1] + 1]; 
            }
            long notTake = (idx + 1 < m) ? dp[idx + 1] : 0; 
            dp[idx] = Math.max(take, notTake);
        }

        return dp[0];
    }
}
