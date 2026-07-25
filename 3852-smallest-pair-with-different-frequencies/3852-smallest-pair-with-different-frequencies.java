class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int[] freq=new int[101];
        for(int i:nums)
            freq[i]++;
        int sm=1000,smFreq=-1;
        for(int i=0;i<101;i++)
        {
            if(freq[i]!=0) 
            {
                sm=i;
                smFreq=freq[i];
                break;
            }
        }
        int sm2=1000,smFreq2=-1;
        for(int i=0;i<101;i++)
        {
            if(freq[i]!=0 && freq[i] != smFreq)
            {
                sm2=i;
                smFreq2=freq[i];
                break;
            }
        }
        if(sm==1000 || sm2==1000 || smFreq==-1 || smFreq2==-1) return new int[]{-1,-1};
        return new int[]{sm,sm2};
    }
}