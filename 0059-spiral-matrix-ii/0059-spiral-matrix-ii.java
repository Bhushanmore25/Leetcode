class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat=new int[n][n];
        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;
        int count=1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) 
        {
            for (int i = colBegin; i <= colEnd; i++) {
                mat[rowBegin][i]=count++;
            }
            rowBegin++;
            for(int i=rowBegin;i<=rowEnd;i++)
            {
                mat[i][colEnd]=count++;
            }
            colEnd-=1;
            if(rowBegin<=rowEnd)
            {
                for(int i=colEnd;i>=colBegin;i--)
                {
                    mat[rowEnd][i]=count++;
                }
                rowEnd-=1;
            }
            if(colBegin<=colEnd)
            {
                for(int i=rowEnd;i>=rowBegin;i--)
                {
                    mat[i][colBegin]=count++;
                }
                colBegin+=1;
            }
        }
        return mat;
    }
}