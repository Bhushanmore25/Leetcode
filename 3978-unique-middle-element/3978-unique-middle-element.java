class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int mid=nums[nums.length/2],midIdx=nums.length/2;
        for(int i=0;i<nums.length;i++) if(nums[i]==mid && i != midIdx) return false;
        return true;
    }
}