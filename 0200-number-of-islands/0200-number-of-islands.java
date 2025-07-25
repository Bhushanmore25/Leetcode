class Solution {
    public static int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    public static void dfs(char[][] grid,boolean[][] visited,int i,int j,int m,int n)
    {
        visited[i][j]=true;
        for(int[] x:directions)
        {
            int newx=x[0]+i;
            int newy=x[1]+j;
            if(newx>=0 && newx<m && newy>=0 && newy<n && grid[newx][newy] == '1' &&  !visited[newx][newy])
            {
                dfs(grid,visited,newx,newy,m,n);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    dfs(grid,visited,i,j,m,n);
                    count++;
                }
            }
        }
        return count;
    }
}