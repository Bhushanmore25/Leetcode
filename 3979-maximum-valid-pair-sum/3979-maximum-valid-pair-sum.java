class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int res=0,pre=0,n=nums.length;
        for(int i=0;i<n-k;i++)
        {
            pre=Math.max(pre,nums[i]);
            res=Math.max(res,pre+nums[i+k]);
        }
        return res;
    }
}