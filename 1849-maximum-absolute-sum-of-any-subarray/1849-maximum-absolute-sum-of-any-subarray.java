class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum1=0,sum2=0;
        int maxi=nums[0],mini=nums[0];
        for(int i:nums)
        {
            sum1+=i;
            maxi=Math.max(sum1,maxi);
            sum2+=i;
            mini=Math.min(sum2,mini);
            if(sum1<0) sum1=0;
            if(sum2>0) sum2=0;
        }
        mini=Math.abs(mini);
        if(mini>maxi) return mini;
        return maxi;
    }
}