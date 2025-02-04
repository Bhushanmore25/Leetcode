class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxi=nums[0],maxsum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
                maxi+=nums[i];
            }
            else{
                maxi=nums[i];
            }
            maxsum=Math.max(maxsum,maxi);
        }
        return maxsum;
    }
}