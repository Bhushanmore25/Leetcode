class Solution {

    private boolean check(int[] row, int[] col, int priDia, int secDia) {
        for (int i = 0; i < 3; i++) {
            if (row[i] != 15 || col[i] != 15) return false;
        }
        return priDia == 15 && secDia == 15;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {

                HashSet<Integer> set = new HashSet<>();
                int[] row = new int[3];
                int[] col = new int[3];
                int priDia = 0, secDia = 0;
                boolean valid = true;

                for (int x = 0; x < 3 && valid; x++) {
                    for (int y = 0; y < 3; y++) {
                        int val = grid[i + x][j + y];
                        if (val < 1 || val > 9 || !set.add(val)) {
                            valid = false;
                            break;
                        }

                        row[x] += val;
                        col[y] += val;
                        if (x == y) priDia += val;
                        if (x + y == 2) secDia += val;
                    }
                }

                if (valid && check(row, col, priDia, secDia)) {
                    count++;
                }
            }
        }
        return count;
    }
}
