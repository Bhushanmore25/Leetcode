class Solution {

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
    public static void nQueens(char[][] chess,List<List<String>> s,int row)
    {
        if (row == chess.length) {
            List<String> currentSolution = new ArrayList<>();
            for (char[] chars : chess) {
                currentSolution.add(new String(chars));
            }
            s.add(currentSolution);
            return;
        }

        for(int j=0;j<chess.length;j++)
        {
            if (isSafe(chess, row, j)) {
                chess[row][j] = 'Q'; 
                nQueens(chess, s, row + 1); 
                chess[row][j] = '.'; 
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chess=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                chess[i][j]='.';
            }
        }
        List<List<String>> s= new ArrayList<>();
        nQueens(chess,s,0);
        return s;
    }
}