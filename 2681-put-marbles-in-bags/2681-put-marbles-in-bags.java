class Solution {
    public long putMarbles(int[] weights, int k) {
        int n=weights.length;
        int[] pair_wt=new int[n-1];
        for(int i=0;i<n-1;i++)
        {
            pair_wt[i]=weights[i]+weights[i+1];
        }
        Arrays.sort(pair_wt);
        long ans=0l;
        for(int i=0;i<k-1;i++)
        {
            ans+= pair_wt[n-2-i] - pair_wt[i];
        }
        return ans;
    }
}