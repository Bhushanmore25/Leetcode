class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int idx=n-1;idx>=0;idx--)
        {
            
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[idx][buy] = Math.max(-prices[idx] + dp[idx + 1][0], dp[idx + 1][1]);
                } else {
                    dp[idx][buy] = Math.max(prices[idx] + dp[idx + 1][1]-fee, dp[idx + 1][0]);
                }
            }
        
        }
        return dp[0][1];
    }
}