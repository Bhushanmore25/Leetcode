class Solution {
    public static int findPath(int[][] obs,int i,int j,int[][] dp)
    {
        if(i>=0 && j>=0 && obs[i][j]==1) return 0;
        if(i==0&& j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int left=findPath(obs,i-1,j,dp);
        int up=findPath(obs,i,j-1,dp);
        return dp[i][j]=left+up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        return findPath(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1,dp);
    }
}