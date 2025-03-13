class Solution {
    public static int helper(int[] nums)
    {
        int n=nums.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i==0) dp[i]=nums[i];
            else
            {
                int pick=nums[i],notpick=dp[i-1];
                if(i>1) pick+=dp[i-2];
                dp[i]=Math.max(pick,notpick);
            }
        }

        return dp[n-1];
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int[] left=new int[n-1];
        int[] right=new int[n-1];
        for(int i=0;i<n;i++)
        {
            if(i>0) left[i-1]=nums[i];
            if(i<n-1) right[i]=nums[i];
        }
        return Math.max(helper(left),helper(right));
    }
}