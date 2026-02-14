class Solution {
    long NEG = Long.MIN_VALUE;
    
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        Long dp[][][] = new Long[m+1][n+1][k+1];

        return helper(0, 0, k, nums1, nums2, dp);
    }

    private long helper(int i, int j, int k, int[] nums1, int[] nums2, Long[][][] dp){
        if(k == 0) return 0;
        if(i==nums1.length || j==nums2.length) return NEG;

        if(dp[i][j][k] != null) return dp[i][j][k];

        long ans = NEG;

        ans = Math.max(ans, helper(i+1, j, k, nums1, nums2, dp));
        ans = Math.max(ans, helper(i, j+1, k, nums1, nums2, dp));

        long pick = helper(i+1, j+1, k-1, nums1, nums2, dp);
        if(pick != NEG){
            pick += 1L*nums1[i]*nums2[j];
            ans = Math.max(ans, pick);
        }

        return dp[i][j][k] = ans;
    }

}