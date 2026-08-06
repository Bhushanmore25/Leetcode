class Solution {
    public static int prod(int x)
    {
        int t=1;
        while(x!=0)
        {
            t*=x%10;
            x/=10;
        }
        return t;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100000;i++)
        {
            if(prod(i)%t==0) return i;
        }
        return -1;
    }
}