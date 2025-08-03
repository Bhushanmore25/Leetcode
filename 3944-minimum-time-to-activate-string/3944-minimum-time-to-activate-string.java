class Solution {
    private long countSubstrings(String s) {
        long count = 0;
        int last = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                last = i;
            }
            count += (last + 1);
        }

        return count;
    }

    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        int left = 0, right = n - 1;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            char[] newS = s.toCharArray();

            for (int i = 0; i <= mid; i++) {
                newS[order[i]] = '*';
            }

            long subCount = countSubstrings(new String(newS));

            if (subCount >= (long) k) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
