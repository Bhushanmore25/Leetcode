class Solution {
    public static int bs(long[] pre,long val)
    {
        int l=0,r=pre.length-1;
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if (pre[mid] <= val)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
    public int[] countTasks(int[] t, int[] s) {
        long[] pre=new long[t.length];
        pre[0]=t[0];
        for(int i=1;i<t.length;i++) pre[i]=pre[i-1] + t[i];
        int[] ans=new int[s.length];
        int currIdx = 0;
        long done = 0;

        for (int i = 0; i < s.length; i++) {

            done += s[i];
            if (done >= pre[t.length - 1]) {
                ans[i] = 0;
                done = 0;
                currIdx = 0;
                continue;
            }
            currIdx = bs(pre, done);

            ans[i] = t.length - currIdx;
        }

        return ans;
    }
}