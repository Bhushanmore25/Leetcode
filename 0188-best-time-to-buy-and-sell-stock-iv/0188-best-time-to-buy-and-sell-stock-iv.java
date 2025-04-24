class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];

        for(int idx=n-1;idx>=0;idx--)
        {
            for(int buy=0 ; buy<2; buy++)
            {
                for(int trans=1;trans<k+1;trans++)
                {

                    if(buy==1)
                    {
                        dp[idx][buy][trans]=Math.max(-prices[idx] + dp[idx+1][0][trans], dp[idx+1][1][trans]);
                    }
                    else{
                        dp[idx][buy][trans]=Math.max(prices[idx] + dp[idx+1][1][trans-1] , dp[idx+1][0][trans]);
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}