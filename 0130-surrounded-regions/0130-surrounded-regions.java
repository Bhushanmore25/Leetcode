class Solution {
   static int [] dx = {-1,1,0,0};
   static int [] dy = {0,0,-1,1};

    public static void dfs(char [][]board ,int x, int y){
        board[x][y] = '#';
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<4; i++){
            int nR = x + dx[i];
            int nC = y + dy[i];

            if(nR >0 && nR <n && nC >0 && nC <m && board[nR][nC] == 'O'){
                dfs(board,nR,nC);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i == 0 || i == n-1 || j == 0 || j == m-1) && board[i][j] == 'O'){
                    dfs(board,i,j);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}