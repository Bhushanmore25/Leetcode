class Solution {
    public static int helper(String s,String t,int i,int j,int[][] dp)
    {
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]=helper(s,t,i-1,j-1,dp);
        //insert
        int insert= 1 + helper(s,t,i,j-1,dp);
        //replace
        int replace= 1 + helper(s,t,i-1,j-1,dp);
        //delete
        int delete= 1 + helper(s,t,i-1,j,dp);

        return dp[i][j]= Math.min(insert,Math.min(replace,delete));
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        return helper(word1,word2,m-1,n-1,dp);
    }
}