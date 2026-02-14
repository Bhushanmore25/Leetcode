class Solution {
    public int dominantIndices(int[] nums) {
        int total=0;
        for(int i:nums) total+=i;
        int count=0;
        for(int i=0;i<nums.length-1;i++)
        {
            total-=nums[i];
            if(total< nums[i] * (nums.length-i-1)) count++;
        }
        return count;
    }
}