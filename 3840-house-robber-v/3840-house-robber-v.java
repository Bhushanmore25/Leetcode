class Solution {
    public long rob(int[] nums, int[] colors) {
        int n=nums.length;
        long[] prefix=new long[n+1];
        prefix[1]=nums[0];
        for(int i=1;i<n;i++)
        {
            if(colors[i]!=colors[i-1])
            {
                prefix[i+1]=(long)(prefix[i]+nums[i]);
            }
            else{
                long val=prefix[i-1];
                if(prefix[i]> (long)val+nums[i])
                {
                    prefix[i+1]=prefix[i];
                }
                else{
                    prefix[i+1]=(long)val+nums[i];
                }
            }
        }
        return prefix[n];
    }
}