class Solution {
    public int maxJump(int[] stones) {
        int n=stones.length;
        if(n==2) return stones[n-1];
        int dist=0;
        for(int i=0;i<n-2;i++)
        {
            dist=Math.max(dist,stones[i+2]-stones[i]);
        }
        return dist;
    }
}