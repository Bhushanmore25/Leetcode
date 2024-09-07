class Solution {
    public boolean canJump(int[] nums) {
        int value=nums.length-1;
        for(int i=value;i>=0;i--){
            if(i+nums[i]>=value)
            {
                value=i;
            }
        }
        if(value==0)
        {
            return true;
        }
        else{
            return false;
        }
    }
}