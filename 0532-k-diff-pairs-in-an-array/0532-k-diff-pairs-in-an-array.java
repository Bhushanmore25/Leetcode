class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,n=nums.length;
        int count=0;
        for(int r=0;r<n;r++)
        {
            while(r<n-1 && nums[r]==nums[r+1]) r++;
            while(nums[r]-nums[l]>k) l++;
            if(r!=l && Math.abs(nums[r]-nums[l])==k) count++;
        }
        return count;
    }
}