class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(byte c: s.getBytes()) freq[c - 'a']++;
        int res = 0;
        for(int i: freq) {
            if (i == 0) continue;
            res += (i & 1 ^ 1) << 1 | i & 1;
        }
        return res;
    }
}