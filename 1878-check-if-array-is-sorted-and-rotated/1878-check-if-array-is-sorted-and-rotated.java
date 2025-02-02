class Solution {
    public boolean check(int[] nums) {
        int count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]<=nums[i])
            {
                continue;
            }
            if(nums[i-1]>nums[i] && count>0)
            {
                count--;
            }
            else{
                return false;
            }
        }
        if(count==0 && nums[nums.length-1] > nums[0])
        {
            return false;
        }
        return true;
    }
}