class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans=0,count=0;
        int l=-1,r=0,n=nums.length;
        long[] prefix=new long[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=(long)nums[i]+prefix[i-1];
        }
        while (r < n) {
            if (l < 0) 
                count = (long)prefix[r] * (r + 1);
            else 
                count = (long)(prefix[r] - prefix[l]) * (r - l);
            
            if (count < k) {
                ans += ((long)r - l);
                r++;
            } else {
                l++;
            }
        }
        return ans;
    }
}