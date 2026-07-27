class Solution {
    public static int sumOfDigits(int n)
    {
        int sum=0;
        while(n!=0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int largestInteger(int n, int s) {
        int st=0,end=-1,large=-1;
        if(n==1)
        {
            end=9;
        }
        else if(n==2)
        {
            end=99;
        }
        else if(n==3)
        {
            end=999;
        }
        else if(n==4)
        {
            end=9999;
        }
        else if(n==5)
        {
            end=99999;
        }
        for(int i=st;i<=end;i++)
        {
            if(sumOfDigits(i)==s) large=Math.max(large,i);
        }
        return large;
    }
}