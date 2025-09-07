class Solution {
    public int[] sumZero(int n) {
        if(n==1) return new int[]{0};
        int[] ar=new int[n];
        for(int i=0;i<n-1;i++)
        {
            ar[i]=i+1;
        }
        ar[n-1]= -(n*(n-1)/2);
        return ar;
    }
}