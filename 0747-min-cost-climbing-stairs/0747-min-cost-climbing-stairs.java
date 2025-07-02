class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++)
        {
            if(i<2) dp[i+1]=cost[i];
            else
            {
                dp[i+1]=Math.min(dp[i]+cost[i],dp[i-1]+cost[i]);
            }
        }
        return Math.min(dp[n],dp[n-1]);
    }
}