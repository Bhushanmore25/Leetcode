class Solution {
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        if(nums.length==1) return 0;
        if(nums.length==2) return nums[0]>nums[1]?0:1;
        while(left<right)
        {
            int mid=(right+left)/2;
            if( nums[mid]>nums[mid+1])
            {
                right=mid;
            }
            else 
            {
                left=mid+1;
            }
        }
        // if(nums[0]>nums[1]) return 0;
        // if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        return left;
    }
}