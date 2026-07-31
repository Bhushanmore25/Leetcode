class Solution {
    public String largestPalindromic(String num) {
        int[] c = new int[10];

        for (char ch : num.toCharArray()) {
            c[ch - '0']++;
        }

        char mid = 'a';
        StringBuilder st = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            if ((c[i] & 1) == 1 && mid == 'a') {
                mid = (char) ('0' + i);
            }

            int pairs = c[i] / 2;

            // Prevent leading zeros
            if (i == 0 && st.length() == 0) {
                continue;
            }

            while (pairs-- > 0) {
                st.append((char) ('0' + i));
            }
        }

        // If no pair exists, return the largest single digit.
        if (st.length() == 0) {
            return mid == 'a' ? "0" : String.valueOf(mid);
        }

        String left = st.toString();
        String right = new StringBuilder(left).reverse().toString();

        return left + (mid == 'a' ? "" : mid) + right;
    }
}