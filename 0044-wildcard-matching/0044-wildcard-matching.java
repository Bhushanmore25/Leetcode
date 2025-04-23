class Solution {
    public static boolean match(String s, String p, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            dp[i][j] = match(s, p, i - 1, j - 1, dp) ? 1 : 0;
        } else if (p.charAt(j) == '*') {
            dp[i][j] = (match(s, p, i, j - 1, dp) || match(s, p, i - 1, j, dp)) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j] == 1;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return match(s, p, m - 1, n - 1, dp);
    }
}
