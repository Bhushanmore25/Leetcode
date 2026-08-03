class Solution {
    public static boolean helper(int st,int end,boolean chance,int[] piles,int a,int b)
    {
        if(st>end) return a>b;
        if(st == end)
        {
            if(chance) a+=piles[st];
            else b+=piles[st];
            return a>b;
        }
        boolean ans=false;
        if(chance)
        {
            ans= ans || helper(st+1,end,!chance,piles,a+piles[st],b);
            ans= ans || helper(st,end-1,!chance,piles,a+piles[end],b);
        }
        else{
            ans= ans || helper(st+1,end,!chance,piles,a,b+piles[st]);
            ans= ans || helper(st,end-1,!chance,piles,a,b+piles[end]);
        }
        return ans;
    }
    public boolean stoneGame(int[] piles) {
        // return helper(0,piles.length-1,true,piles,0,0);
        return true;
    }
}