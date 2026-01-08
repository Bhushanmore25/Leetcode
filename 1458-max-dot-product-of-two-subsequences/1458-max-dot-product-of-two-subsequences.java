class Solution {
    public int recursion(int[] nums1, int[] nums2, int i, int j,int[][] dp) {
        if (i == nums1.length || j == nums2.length)
            return Integer.MIN_VALUE / 2; 
        if(dp[i][j]!=Integer.MIN_VALUE/2) return dp[i][j];
        int pick = nums1[i] * nums2[j] + Math.max(0, recursion(nums1, nums2, i + 1, j + 1,dp));
        int skipI = recursion(nums1, nums2, i + 1, j,dp);
        int skipJ = recursion(nums1, nums2, i, j + 1,dp);

        return dp[i][j]=Math.max(pick, Math.max(skipI, skipJ));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int total=0,m=nums1.length,n=nums2.length;
        int[][] dp=new int[m+1][n+1];
        for(int i[]:dp) Arrays.fill(i,Integer.MIN_VALUE/2);

        return recursion(nums1,nums2,0,0,dp);
    }
}