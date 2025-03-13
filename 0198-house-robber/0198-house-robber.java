class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; 
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
}