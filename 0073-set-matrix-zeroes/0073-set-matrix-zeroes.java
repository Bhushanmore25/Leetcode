class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> li=new ArrayList<>();
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0) li.add(new int[]{i,j});
            }
        }
        for(int k=0;k<li.size();k++)
        {
            int x = li.get(k)[0];  
            int y = li.get(k)[1];

            for (int i = 0; i < m; i++) {
                matrix[i][y] = 0;
            }

            for (int j = 0; j < n; j++) {
                matrix[x][j] = 0;
            }
        }
    }
}