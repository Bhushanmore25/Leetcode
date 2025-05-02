import java.util.*;

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                int dist = 1;
                int j = i + 1;
                while (j < n && dominoes.charAt(j) == '.') {
                    right[j] = dist;
                    dist++;
                    j++;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                int dist = 1;
                int j = i - 1;
                while (j >= 0 && dominoes.charAt(j) == '.') {
                    left[j] = dist;
                    dist++;
                    j--;
                }
            }
        }

        StringBuilder ans = new StringBuilder(dominoes);
        for (int i = 0; i < n; i++) {
            if (ans.charAt(i) == '.') {
                if (left[i] == right[i]) {
                    continue;
                } else if (left[i] < right[i]) {
                    ans.setCharAt(i, 'L');
                } else if (right[i] < left[i]) {
                    ans.setCharAt(i, 'R');
                }
            }
        }

        return ans.toString();
    }
}
