class Solution {
    public void gameOfLife(int[][] a) {
        int m=a.length,n=a[0].length;
        int[][] dir = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,1},
            {1,-1},{1,0},{1,1}
        };
        int[][] copy = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                copy[i][j] = a[i][j];
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count=0;
                for(int[] z:dir)
                {
                    int x=i+z[0];
                    int y=j+z[1];
                    if(x>=0 && x<m && y>=0 && y<n && copy[x][y]==1) {
                        count++;
                    }
                }
                if(copy[i][j]==1)
                {
                    if(count==2 || count==3) a[i][j]=1;
                    else a[i][j]=0;
                }
                else{
                    if(count==3) a[i][j]=1;
                }
            }
        }
        // return a;
    }
}