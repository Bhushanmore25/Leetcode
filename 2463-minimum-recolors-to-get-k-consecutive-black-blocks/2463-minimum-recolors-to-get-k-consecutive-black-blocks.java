class Solution {
    public int minimumRecolors(String blocks, int k) {
        int black=0,white=0,mini=Integer.MAX_VALUE;
        for(int i=0;i<blocks.length();i++)
        {
            if(blocks.charAt(i)=='B') black++;
            else white++;
            if(i<=k-2)
            {
                continue;
            }
            if(black<=k)
            {
                mini=Math.min(mini,k-black);
            }
            else{
                mini=0;
                break;
            }
            if(blocks.charAt(i-k+1)=='B') black--;
            else white--;
        }
        return mini;
    }
}