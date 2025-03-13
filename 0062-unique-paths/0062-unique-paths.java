class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] dp=new int[m][n];
        // dp[0][0]=1;
        int[] dp=new int[n];
        for (int i=0;i<m;i++) {
            int[] temp=new int[n];
            for(int j=0;j<n;j++)
            {   
                if(i==0 && j==0)
                {
                    temp[j]=1;
                }
                else{
                    int left=0,up=0;
                    if(i>0) left=dp[j];
                    if(j>0) up=temp[j-1];
                    temp[j]=up+left;
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}