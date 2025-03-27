class Solution {
    public int[][] dp= new int[301][5001];
    public static int ways(int[][] dp,int amount,int[] coins,int idx)
    {
        if(amount==0) return 1;
        if(idx<0) return 0;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int ans=0;
        for(int i=0;i<=amount;i+=coins[idx])
        {
            ans+=ways(dp,amount-i,coins,idx-1);
        }
        return dp[idx][amount]=ans;
    }
    public int change(int amount, int[] coins) {
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return ways(dp,amount,coins,coins.length-1);
    }
}