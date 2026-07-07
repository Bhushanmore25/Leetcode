class Solution {
    public long sumAndMultiply(int n) {
        int num=0,sum=0;
        while(n!=0)
        {
            int temp=n%10;
            sum+=temp;
            if(temp!=0) num=num*10+temp;
            n/=10;
        }
        while(num!=0)
        {
            int temp=num%10;
            n=n*10+temp;
            num/=10;
        }
        return (long)sum*n;
    }
}