class Solution {
    // public static int helper(String s,String t,int i,int j,int[][] dp)
    // {
    //     if(j==0) return 1;
    //     if(i==0) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(s.charAt(i-1)==t.charAt(j-1))
    //     {
    //         return helper(s,t,i-1,j-1,dp) + helper(s,t,i-1,j,dp);
    //     }
    //     return helper(s,t,i-1,j,dp);
    // }
    public int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][0]=1;

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]= dp[i-1][j-1] + dp[i-1][j];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }


        return dp[m][n];
    }
}