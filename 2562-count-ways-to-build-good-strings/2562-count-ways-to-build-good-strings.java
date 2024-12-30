class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD=1_000_000_007;
        int ans=0;
        int[] dp=new int[high+1];
        dp[0]=1;
        for(int i=1;i<=high;i++)
        {
            if(i>=one)
            {
                dp[i]=(dp[i]+dp[i-one])%MOD;
            }
            if(i>=zero)
            {
                dp[i]=(dp[i]+dp[i-zero])%MOD;
            }
            if(i>=low)
            {
                ans=(ans+dp[i])%MOD;
            }
        }
        return ans;
    }
}