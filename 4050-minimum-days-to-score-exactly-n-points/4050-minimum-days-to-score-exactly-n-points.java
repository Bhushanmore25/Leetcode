class Solution {
    public int[] dp;
    public int helper(int n)
    {
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=200001;
        for(int i=1;i<=n;i++)
        {
            int val= i*(i+1)/2;
            if(val>n) break;
            int rem=n-val;
            if(rem == 0) ans=Math.min(ans,i);
            else ans=Math.min(ans, i+1+helper(rem));
        }
        return dp[n]=ans;
    }
    public int minDays(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
}