class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                total += (long)grid[i][j];
            }
        }
        long curr=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                curr+=(long)grid[i][j];
            }
            if(2*curr==total) return true;
        }
        curr=0;
        for(int i=0;i<grid[0].length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                curr+=(long)grid[j][i];
            }
            if(2*curr==total) return true;
        }
        return false;
    }
}