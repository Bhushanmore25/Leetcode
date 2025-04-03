class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,r=nums.length-1;
        int sum=0,count=0;
        while(l<r)
        {
            sum=nums[l]+nums[r];
            if(sum==k)
            {
                count++;
                l++;
                r--;
            }
            else if(sum>k)
            {
                r--;
            }
            else{
                l++;
            }
        }
        return count;
    }
}