class Solution {
    public long countSubarrays(int[] nums, int k) {
        int l=0,r=0,n=nums.length,maxi=Integer.MIN_VALUE;
        long freq=0,ans=0;
        for(int i=0;i<n;i++) maxi=Math.max(maxi,nums[i]);
        for( r=0; r<n; r++ )
        {
            if(nums[r]==maxi)
            {
                freq++;
            }
            if(freq>=k)
            {
                
                while(l<=r)
                {
                    if(nums[l]==maxi) freq--;
                    ans+=(n-r);
                    l++;
                    if(freq<k) break;
                }
            }
        }
        return ans;
    }
}