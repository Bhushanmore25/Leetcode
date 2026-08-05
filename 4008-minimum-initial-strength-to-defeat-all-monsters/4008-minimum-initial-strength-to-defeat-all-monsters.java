class Solution {
    public static boolean check(long mid, int[] mons, long[] b) {

        long bonus = 0;
        long strength = mid;

        for(int i = 0; i < mons.length; i++) {

            bonus += b[i];

            if(strength + bonus < mons[i])
                return false;

            strength = Math.max(0L, strength - mons[i]);
        }

        return true;
    }
    public long minInitialStrength(int[] mons, int[][] boosts) {
        long[] b=new long[mons.length+1];
        for(int[] i:boosts)
        {
            b[i[0]]+=i[2];
            b[i[1]+1]-=i[2];
        }
        long l=0,r=Long.MAX_VALUE,ans=-1;
        while(l<=r)
        {
            long mid=l+(r-l)/2;
            if(check(mid,mons,b))
            {
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}