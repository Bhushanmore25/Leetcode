class Solution {
    public static void flip(int[] nums,int i,int j,int k)
    {
        nums[i]=1-nums[i];
        nums[j]=1-nums[j];
        nums[k]=1-nums[k];
    }
    public int minOperations(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-2;i++)
        {
            if(nums[i]==0)
            {
                flip(nums,i,i+1,i+2);
                count++;
            }
        }
        if(nums[nums.length-1]!=1 || nums[nums.length-2]!=1) return -1;
        return count;
    }
}