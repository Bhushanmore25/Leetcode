class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        Set<Integer> seen = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (seen.contains(A[i])) {
                count++;
            } else {
                seen.add(A[i]);
            }

            if (seen.contains(B[i])) {
                count++;
            } else {
                seen.add(B[i]);
            }

            ans[i] = count;
        }
        return ans;
    }
}