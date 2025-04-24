class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int idx=n-1;idx>=0;idx--)
        {
            
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[idx][buy] = Math.max(-prices[idx] + dp[idx + 1][0], dp[idx + 1][1]);
                } else {
                    dp[idx][buy] = Math.max(prices[idx] + dp[idx + 1][1], dp[idx + 1][0]);
                }
            }
        
        }
        return dp[0][1];
    }
    //recursion
    // public static int profit(int[] prices,int idx,int buy,int[][] dp)
    // {
    //     if(idx==prices.length)
    //     {
    //         return 0;
    //     }
    //     if(dp[idx][buy]!=-1) return dp[idx][buy];
    //     if(buy==1)
    //     {
    //         return dp[idx][buy]=Math.max(-prices[idx] + profit(prices , idx+1, 0, dp) , 0 + profit(prices , idx+1, 1, dp));
    //     }
    //     else{
    //         return dp[idx][buy]=Math.max(prices[idx] + profit(prices, idx+1,1,dp) , profit(prices , idx+1, 0,dp));
    //     }
    // }
    // public int maxProfit(int[] prices) {
    //     int n=prices.length;
    //     int[][] dp=new int[n][2];
    //     for(int[] i:dp) Arrays.fill(i,-1);
    //     return profit(prices,0,1,dp);
    // }
    //greedy
    // public int maxProfit(int[] prices) {
    //     int profit = 0;
    //     for(int i=1;i<prices.length;i++) {
    //         if(prices[i] > prices[i-1]) {
    //             profit += prices[i] - prices[i-1];
    //         }
    //     }
    //     return profit;
    // }
}