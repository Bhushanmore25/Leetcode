import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] nums = new int[c + 2];
        nums[0] = 0;
        nums[c + 1] = n;
        
        for (int i = 0; i < c; i++) {
            nums[i + 1] = cuts[i];
        }
        
        Arrays.sort(nums);
        
        int[][] dp = new int[c + 2][c + 2];
        
        for (int len = 1; len <= c; len++) { 
            for (int i = 1; i + len - 1 <= c; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k <= j; k++) {
                    int cost = (nums[j + 1] - nums[i - 1]) + dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        return dp[1][c];
    }
}



// class Solution {
//     public static int helper(int[] nums, int n, int i, int j,int[][] dp) {
//         if (i > j) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         int mini = Integer.MAX_VALUE;
//         for (int k = i; k <= j; k++) {
//             int left = (i > 0) ? nums[i - 1] : 0;
//             int right = (j + 1 < nums.length) ? nums[j + 1] : n;
            
//             int cost = right- left + helper(nums, n, i, k - 1,dp) + helper(nums, n, k + 1, j,dp);
//             mini = Math.min(mini, cost);
//         }
//         return dp[i][j]=mini;
//     }

//     public int minCost(int n, int[] cuts) {
//         int[] nums = new int[cuts.length + 2];
//         nums[0] = 0;
//         for (int i = 0; i < cuts.length; i++) {
//             nums[i + 1] = cuts[i];
//         }
//         nums[nums.length - 1] = n;
//         int[][] dp=new int[n][n];
//         for(int i[]:dp) Arrays.fill(i,-1);
//         Arrays.sort(nums);        
//         return helper(nums, n, 1, nums.length - 2,dp);
//     }
// }
