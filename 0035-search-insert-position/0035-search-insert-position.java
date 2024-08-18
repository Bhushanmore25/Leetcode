class Solution {
    public int searchInsert(int[] nums, int target) {
        int first=0;
        int last=nums.length-1;
        int mid=(first+last)/2;
        while(first<=last)
        {
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]>target)
            {
                last=mid-1;
            }
            else{
                first=mid+1;
            }
            mid=(first+last)/2;
        }
        return last+1;

    }
}