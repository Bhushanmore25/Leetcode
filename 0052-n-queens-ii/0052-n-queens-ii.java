class Solution {
    static int count=0;
    public static boolean isSafe(char[][] chess,int row,int j)
    {
        for(int i=row-1;i>=0;i--)
        {
            if(chess[i][j]=='Q')
            {
                return false;
            }
        }
        for(int i=row-1 , k=j-1;i>=0 && k>=0;i--,k--)
        {
            if(chess[i][k]=='Q')
            {
                return false;
            }
        }
        for(int i=row-1 , k=j+1 ; i>=0 && k<chess.length ; i-- , k++)
        {
            if(chess[i][k]=='Q')
            {
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char[][] chess,int row,int[] count)
    {
        if (row == chess.length) {
            count[0]++;
            return;
        }

        for(int j=0;j<chess.length;j++)
        {
            if (isSafe(chess, row, j)) {
                chess[row][j] = 'Q'; 
                nQueens(chess, row + 1,count); 
                chess[row][j] = '.'; 
            }
        }

    }
    public int totalNQueens(int n) {
        char[][] chess=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                chess[i][j]='.';
            }
        }
        int[] count = {0};
        nQueens(chess, 0, count);
        return count[0];
    }
}