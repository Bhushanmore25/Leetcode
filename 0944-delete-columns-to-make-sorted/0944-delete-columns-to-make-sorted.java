class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length,m=strs[0].length();
        if(n==1) return 0;
        int[] arr=new int[m];
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((strs[i].charAt(j) - strs[i-1].charAt(j)) < 0) arr[j]=1;
            }
        }
        int count=0;
        for(int i=0;i<m;i++) if(arr[i]==1) count++;
        return count;
    }
}