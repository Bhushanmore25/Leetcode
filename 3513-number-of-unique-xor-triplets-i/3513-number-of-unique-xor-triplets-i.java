class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int len=nums.length;
        if(len==1) return len;
        if(len==2) return len;
        int x=2;
        for(int i=1;i<32;i++)
        {
            if(len<x) return x;
            if(len==x) return x*2;
            x*=2;
        }
        return 0;
    }
}