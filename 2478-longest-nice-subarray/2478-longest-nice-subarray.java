class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        int left = 0,right=0;
        int cursum = 0;
        int xorsum = 0;
        
        while(right<n)
        {
            cursum+=nums[right];
            xorsum^=nums[right];
            while(cursum!=xorsum)
            {
                cursum-=nums[left];
                xorsum^=nums[left];
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        
        return maxLength;
    }
}