class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        Long total=(long)0;
        Long[] prefix=new Long[n+1];
        Long[] prefixOriginal=new Long[n+1];
        prefix[0]=(long)0;
        prefixOriginal[0]= (long)0;
        for( int i = 1 ; i <= n ; i++ )
        {
            prefix[i] = prefix[i-1] + (long)prices[i-1];
            prefixOriginal[i] = prefixOriginal[i-1] + (long)(strategy[i-1] * prices[i-1]);
        }
        total = prefixOriginal[n];
        Long ans=total;
        for( int i = 1 ; i <= n-k+1 ; i++ )
        {
            long temp=total;
            long org= prefixOriginal[i+k-1] - prefixOriginal[i-1];
            temp-=org;
            long add = prefix[i+k-1] - prefix[i+(k/2)-1];
            ans=Math.max(ans , temp + add);
        }
        return ans;
    }
}