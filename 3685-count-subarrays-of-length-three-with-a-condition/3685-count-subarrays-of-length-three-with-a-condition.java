class Solution {
    public int countSubarrays(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-2;i++)
        {
            int half=nums[i+1];
            int mid=nums[i]+nums[i+2];
            if(half == 2 * mid)
            {
                count++;
            }
        }
        return count;
        
    }
}