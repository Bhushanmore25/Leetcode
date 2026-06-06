class Solution {
    public int[] leftRightDifference(int[] nums) {
        int left=0,right=0,total=0;
        for(int i:nums) total+=i;
        right=total;
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            right-=nums[i];
            ans[i]=Math.abs(left-right);
            left+=nums[i];
        }
        return ans;
    }
}