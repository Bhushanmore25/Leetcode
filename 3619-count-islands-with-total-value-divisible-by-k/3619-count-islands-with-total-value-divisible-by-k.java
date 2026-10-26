class Solution {
    public int[][] directions = new int[][]{
        {-1,0}, {0,-1}, {1,0}, {0,1}
    };

    public int dfs(int[][] grid, boolean[][] visited, int i, int j, int k) {
        visited[i][j] = true;

        int c = grid[i][j];

        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < grid.length &&
                y >= 0 && y < grid[0].length &&
                !visited[x][y] &&
                grid[x][y] != 0) {

                c = (c + dfs(grid, visited, x, y, k)) % k;
            }
        }

        return c;
    }

    public int countIslands(int[][] grid, int k) {
        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j] && grid[i][j] != 0) {
                    int count = dfs(grid, visited, i, j, k);

                    if (count % k == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}