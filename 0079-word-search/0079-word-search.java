class Solution {
    public static boolean dfs(char[][] board, String word, int i, int j, int idx, int m, int n) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j]; 
        board[i][j] = '#'; 

        boolean found = dfs(board, word, i + 1, j, idx + 1, m, n) ||
                        dfs(board, word, i, j + 1, idx + 1, m, n) ||
                        dfs(board, word, i - 1, j, idx + 1, m, n) ||
                        dfs(board, word, i, j - 1, idx + 1, m, n);

        board[i][j] = temp; 
        return found;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { 
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }
}
