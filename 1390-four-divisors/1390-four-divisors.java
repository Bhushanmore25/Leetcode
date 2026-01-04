class Solution {
    public int check(int n)
    {
        int total=0,count=0,limit=(int)Math.sqrt(n)+1;
        for(int i=1;i<limit;i++)
        {
            if(n%i==0)
            {
                total=total + i + n/i;
                if(i==n/i) {
                    count+=1;
                    continue;
                }
                count+=2;
            }
        }
        System.out.println(count+" "+ total);
        if(count!=4) return -1;
        return total;
    }
    public int sumFourDivisors(int[] nums) {
        int total=0;
        for(int i:nums)
        {
            int val=check(i);
            if(val != -1) total+=val;
        }
        return total;
    }
}