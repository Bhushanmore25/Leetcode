class Solution {
    public static int isValid(long n,int x)
    {
        long last=n%10,first=-1;
        while(n!=0)
        {
            if(n<10) first=n;
            n/=10;
        }
        if(last == x && first == x) return 1;
        return 0;
    }
    public int countValidSubarrays(int[] nums, int x) {
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            long sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum+=nums[j];
                c+=isValid(sum,x);
            }
        }
        return c;
    }
}