class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        boolean ans=true;
        for(int i=0;i<grid[0].length;i++)
        {
            for(int j=0;j<grid.length-1;j++)
            {
                if(grid[j][i] != grid[j+1][i]) return false;
            }
        }
        for(int i=0;i<grid[0].length-1;i++)
        {
            if(grid[0][i]==grid[0][i+1]) return false;
        }
        return true;
    }
}