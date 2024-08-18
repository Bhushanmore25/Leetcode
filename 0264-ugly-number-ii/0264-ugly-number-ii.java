class Solution {
    public int nthUglyNumber(int n) {
        int[] num=new int[n];
        num[0]=1;
        int l2=0,l3=0,l5=0;
        for (int i = 1; i < n; i++) {
            num[i]=Math.min( 2*num[l2],Math.min( 3*num[l3],5*num[l5]));
            if (num[i]==2*num[l2]) {
                l2++;
            }
            if (num[i]==3*num[l3]) {
                l3++;
            }
            if (num[i]==5*num[l5]) {
                l5++;
            }
        }
        return num[n-1];
    }
}