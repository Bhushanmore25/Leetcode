class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int[] freq=new int[101];
        int total=0;
        for(int i:nums) {
            freq[i]++;
            total+=i;    
        }
        List<Integer> ans=new ArrayList<>();
        int newt=0;
        for(int i=100;i>=0;i--)
        {   
            while(freq[i]!=0)
            {
                ans.add(i);
                freq[i]--;
                newt+=i;
                if( 2*newt > total ) return ans;
            }
            if( 2*newt > total ) return ans;
        }
        return ans;
    }
}