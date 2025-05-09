class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];

        for(int idx=n-1;idx>=0;idx--)
        {
            for(int buy=0 ; buy<2; buy++)
            {
                for(int trans=1;trans<3;trans++)
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

        return dp[0][1][2];
    }
    //recursion
    // public static int profit(int[] prices,int idx,int buy, int trans,int[][][] dp)
    // {
    //     if(trans==0 || idx==prices.length)
    //     {
    //         return 0;
    //     }
    //     if(dp[idx][buy][trans]!=-1) return dp[idx][buy][trans];
    //     if(buy==1)
    //     {
    //         return dp[idx][buy][trans]=Math.max(-prices[idx] + profit(prices , idx+1, 0, trans,dp) , profit(prices , idx+1, 1,trans,dp));
    //     }
    //     else{
    //         return dp[idx][buy][trans]=Math.max(prices[idx] + profit(prices,idx+1, 1,trans-1,dp), profit(prices, idx+1, 0, trans,dp));
    //     }

    // }
    // public int maxProfit(int[] prices) {
    //     int n=prices.length;
    //     int[][][] dp=new int[n][2][3];
    //     for(int[][] i: dp)
    //         for(int[] j: i)
    //             Arrays.fill(j,-1);
    //     return profit(prices,0,1,2,dp);
    // }
}