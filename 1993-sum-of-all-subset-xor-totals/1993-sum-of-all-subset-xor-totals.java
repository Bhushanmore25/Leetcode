class Solution {
    public int subsetXORSum(int[] nums) {
        return xor(nums,0,0);
    }
    int xor(int[] nums,int curr,int ind){
        if(ind==nums.length) return curr;
        int left = xor(nums,curr^nums[ind],ind+1);
        int right = xor(nums,curr,ind+1);
        return left+right;
    }
    // public int subsetXORSum(int[] nums) {
    //     int sumTotal = 0;

    //     for (int num : nums) {
    //         sumTotal |= num;
    //     }
        
    //     return sumTotal << (nums.length - 1);
    // }
}