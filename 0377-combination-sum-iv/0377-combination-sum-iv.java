class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++)
        {
            int ways=0;
            for(int j=0;j<nums.length;j++)
            {
                if(i>=nums[j] && dp[i-nums[j]]!=0)
                    ways+= dp[i-nums[j]];
            }
            dp[i]=ways;
        }
        return dp[target];

    }
}