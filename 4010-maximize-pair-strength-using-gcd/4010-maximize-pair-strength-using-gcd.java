class Solution {
    public static long GCD(long a,long b)
    {
        if(b==0) return a;
        return GCD(b,a%b);
    }
    public long maxPairStrength(int[] nums) {
        long max=-1;
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                long x=GCD((long)nums[i],(long)nums[j]);
                max=Math.max(max,((long)(1l*nums[i]*nums[j]))/(x*x));
            }
        }
        return max;
    }
}