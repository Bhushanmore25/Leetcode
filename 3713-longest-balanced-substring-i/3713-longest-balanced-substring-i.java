class Solution {
    public static boolean check(int[] freq)
    {
        int val = 0;
        for (int fre : freq) {
            if (fre > 0) {
                if (val == 0) val = fre;
                else if (fre != val) return false;
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int n = s.length();
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                if (check(freq)) {
                    maxi = Math.max(maxi, j - i + 1);
                }
            }
        }
        return maxi;
    }
}