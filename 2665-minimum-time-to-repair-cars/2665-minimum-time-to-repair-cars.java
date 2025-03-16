class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l=1,r=Long.MAX_VALUE,mid,prev_mid=0,ans=0;
        while(l<=r)
        {
            mid=l+(r-l)/2;
            if(mid==prev_mid) break;
            prev_mid=mid;
            long posi=0;
            for(int i:ranks)
            {
                posi+=Math.sqrt(mid/i);
            }
            if(posi>=cars)
            {
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}