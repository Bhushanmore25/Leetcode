class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0,l=nums.length;
        for(int i=0;i<l;i+=2)
        {
            sum+=Math.min(nums[i],nums[i+1]);
        }
        return sum;
    }
}