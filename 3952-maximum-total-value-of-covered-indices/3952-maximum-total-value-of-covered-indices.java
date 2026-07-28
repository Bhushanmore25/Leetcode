class Solution {
    public long maxTotal(int[] nums, String s) {
        int l=0,r=1,n=s.length();
        if(n==1 && s.charAt(0)=='1') return (long)nums[0];
        // long[] pre=new long[n];
        // pre[0]=(long)nums[0];
        // for(int i=1;i<n;i++) pre[i]=(long)nums[i]+pre[i-1];
        int[] a=new int[n];
        long ans=0l;
        Arrays.fill(a,-1);
        if(s.charAt(0)=='1')
        {
            ans+=nums[0];
            a[0]=0;
            l=-1;
        }
        while(r<n)
        {
            if(s.charAt(r)=='1')
            {
                if(-1 == a[r-1]) //not moved
                {
                    if(nums[r-1]>=nums[r])
                    {
                        ans+=nums[r-1];
                        a[r-1]=0; // vrsrted;
                        l=r;
                    }
                    else{
                        ans+=nums[r];
                        a[r]=0; // vrsrted;
                        if(a[r-1]==-1) l=r-1;
                    }
                }
                else //last wala check karu
                {
                    if(l>=0 && nums[r]<=nums[l])
                    {
                        ans+=nums[l];
                        a[l]=0;
                        l=r;
                    }
                    else{
                        ans+=nums[r];
                        a[r]=0;
                    }
                }
            }
            else l=r;
            r++;
        }
        return ans;
    }
}