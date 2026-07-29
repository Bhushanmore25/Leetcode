class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int[] freq=new int[101];
        int count=0;
        for(int i:nums) {
            if(freq[i]<k){ 
                freq[i]++;
                count++;
            }
        }
        int[] ans=new int[count];
        int j=0;
        for(int i=0;i<101;i++)
        {
            if(freq[i]!=0)
            {
                while(freq[i]!=0)
                {
                    freq[i]--;
                    ans[j++]=i;
                }
            }
        }
        return ans;
    }
}