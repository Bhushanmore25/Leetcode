class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder l = new StringBuilder();
        String md = "";

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                if (md.equals("")) {
                    md = String.valueOf((char) (i + 'a'));
                }
                freq[i]--;
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                l.append((char) (i + 'a'));
            }
        }

        String rt = l.reverse().toString();
        l.reverse(); 
        String ans=l.toString() + md + rt;
        return ans;
    }
}
