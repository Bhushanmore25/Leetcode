class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int prev=nums[0];
        int[] newA=new int[nums.length];
        newA[0]=nums[0];
        int count=0;
        for(int i=1;i<nums.length;i++)
        {
            if (nums[i] > prev) {
                newA[i] = nums[i];
                prev = nums[i];
            } else {
                newA[i] = prev + 1;
                prev = newA[i];
                count += (newA[i] - nums[i]);
            }
        }
        return count;
    }
}