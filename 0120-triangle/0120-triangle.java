class Solution {
    public static int getPath(List<List<Integer>> triangle, int m, int i, int j, int[][] dp) {
        if (i == m - 1) return triangle.get(i).get(j);
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        
        int down = getPath(triangle, m, i + 1, j, dp);
        int dg = getPath(triangle, m, i + 1, j + 1, dp);
        
        dp[i][j] = triangle.get(i).get(j) + Math.min(down, dg);
        return dp[i][j];
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        return getPath(triangle, m, 0, 0, dp);
    }
}