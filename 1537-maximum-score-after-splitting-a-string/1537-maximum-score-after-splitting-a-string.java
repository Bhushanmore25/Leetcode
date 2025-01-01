class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        int leftZeros = 0, leftOnes = 0, maxi = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                leftOnes++;
            }

            int rightOnes = totalOnes - leftOnes;
            maxi = Math.max(maxi, leftZeros + rightOnes);
        }

        return maxi;
    }
}