class Solution {
    public static boolean check(int[] nums,int t,int mid)
    {
        int sum=0;
        for(int i:nums)
        {
            if(i%mid!=0) sum++;
            sum+=i/mid;
        }
        System.out.println(sum);
        return sum<=t;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int r = Arrays.stream(nums).max().getAsInt(); 
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(check(nums,threshold,mid))
            {
                // ans=Math.min(ans,mid);
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        // if(ans==Integer.MIN_VALUE) return -1;
        return l;
    }
}