class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq=new int[1001];
        for(int i:arr1) freq[i]++;

        int[] ans=new int[arr1.length];
        int k=0;
        for(int i=0;i<arr2.length;i++)
        {
            while(freq[arr2[i]]!=0)
            {
                freq[arr2[i]]--;
                ans[k++]=arr2[i];
            }
        }
        for(int i=0;i<1001;i++)
        {
            if(freq[i]>0)
            {
                while(freq[i]!=0)
                {
                    ans[k++]=i;
                    freq[i]--;
                }
            }
        }
        return ans;
    }
}