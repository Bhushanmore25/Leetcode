class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] a=new int[100001];
        for(int i=0;i<costs.length;i++)
        {
            a[costs[i]]++;
        }
        int count=0;
        for(int i=0;i<100001;i++)
        {
            if(coins<i) return count;
            while(coins>=i && a[i]!=0)
            {
                count++;
                coins-=i;
                a[i]-=1;
            }
        }
        return count;
    }
}