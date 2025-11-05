class Solution {
    
    // public static int ways(int[][] dp,int amount,int[] coins,int idx)
    // {
    //     if(amount==0) return 1;
    //     if(idx<0) return 0;
    //     if(dp[idx][amount]!=-1) return dp[idx][amount];
    //     int ans=0;
    //     for(int i=0;i<=amount;i+=coins[idx])
    //     {
    //         ans+=ways(dp,amount-i,coins,idx-1);
    //     }
    //     return dp[idx][amount]=ans;
    // }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length;i++) dp[i][0]=1;
        int n=coins.length;
        for(int i=n-1;i>=0;i--)
        {
            for(int sum=1;sum<=amount;sum++)
            {
                int notpick=dp[i+1][sum];
                int pick=0;
                if(coins[i]<=sum)
                    pick=dp[i][sum-coins[i]];
                dp[i][sum]= pick + notpick;
            }
        }
        return dp[0][amount];
    }
}