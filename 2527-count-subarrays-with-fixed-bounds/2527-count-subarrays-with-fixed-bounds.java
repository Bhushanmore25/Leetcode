class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count=0;
        int minidx=-1,maxidx=-1,invalid=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] < minK || nums[i]>maxK) invalid=i;
            if(nums[i]==minK) minidx=i;
            if(nums[i]==maxK) maxidx=i;
            count += (long)Math.max(0 , Math.min(minidx,maxidx) - invalid);
        }
        return count;
    }
}