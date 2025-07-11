class Solution {
    public int maximumDifference(int[] nums) {
        int diff=-1;
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                diff=Math.max(diff,nums[j]-nums[i]);
            }
        }
        if(diff==0) return -1;
        return diff;
    }
}