class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxSize = 1;

        for (int k = 2; k <= Math.min(m, n); k++) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (isMagic(grid, i, j, k)) {
                        maxSize = k;
                    }
                }
            }
        }

        return maxSize;
    }

    private boolean isMagic(int[][] grid, int r, int c, int k) {
        int targetSum = 0;
        for (int j = c; j < c + k; j++) {
            targetSum += grid[r][j];
        }
        for (int i = r; i < r + k; i++) {
            int rowSum = 0;
            for (int j = c; j < c + k; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum != targetSum) return false;
        }
        for (int j = c; j < c + k; j++) {
            int colSum = 0;
            for (int i = r; i < r + k; i++) {
                colSum += grid[i][j];
            }
            if (colSum != targetSum) return false;
        }
        int diag1 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[r + i][c + i];
        }
        if (diag1 != targetSum) return false;
        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag2 += grid[r + i][c + k - 1 - i];
        }
        if (diag2 != targetSum) return false;

        return true;
    }
}
