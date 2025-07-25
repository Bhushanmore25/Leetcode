class Solution {
    public static void dfs(int[][] grid, boolean[][] visited, int i, int j, int[] total, int[][] directions, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == 0) return;

        visited[i][j] = true;
        int temp = 4;
        List<int[]> li = new ArrayList<>();

        for (int[] dir : directions) {
            int newx = dir[0] + i;
            int newy = dir[1] + j;

            if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                if (grid[newx][newy] == 1) {
                    temp -= 1;
                    if (!visited[newx][newy]) {
                        li.add(new int[]{newx, newy});
                    }
                }
            }
        }

        total[0] += temp;
        System.out.println(temp);

        for (int[] x : li) {
            dfs(grid, visited, x[0], x[1], total, directions, m, n);
        }
    }
    public int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        boolean[][] visited=new boolean[m][n];
        int[] total=new int[]{0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j, total, directions, m, n);
                    return total[0];  // only one island, so return after first DFS
                }
            }
        }

        return 0;
    }
}