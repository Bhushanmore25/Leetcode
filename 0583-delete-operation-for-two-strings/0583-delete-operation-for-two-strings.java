class Solution {
    public int minDistance(String s, String t) {
        int m=s.length(),n=t.length();
        int[][] dp=new int[m+1][n+1];

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]= 1 + dp[i-1][j-1];
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int deletion= m - dp[m][n];
        int insertion= n - dp[m][n];
        return insertion + deletion;
    }
}