class Solution {
    public boolean canJump(int[] nums) {
        boolean value=false;
        if (nums.length==0) return value;
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if (i>max) {
                return false;
            }
            max=Math.max(max,i+nums[i]);
        }
        value=true; 

        return value;
    }
}