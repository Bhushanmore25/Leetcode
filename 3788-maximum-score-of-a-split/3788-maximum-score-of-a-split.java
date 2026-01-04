class Solution {
    public long maximumScore(int[] nums) {
        int n=nums.length;
        int[] mini=new int[n];
        long[] prefix=new long[n+1];
        for(int i=0;i<n;i++)
        {
            prefix[i+1]=prefix[i]+nums[i];
        }
        mini[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            mini[i]=Math.min(mini[i+1],nums[i]);
        }
        long ans=Long.MIN_VALUE;
        for(int i=0;i<n-1;i++)
        {
            ans=Math.max(ans,prefix[i+1]-(long)mini[i+1]);
        }
        return ans;

    }
}