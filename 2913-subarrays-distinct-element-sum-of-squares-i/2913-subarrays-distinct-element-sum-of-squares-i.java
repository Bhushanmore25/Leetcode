class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        for(int i=0;i<nums.size();i++){
            int[] freq=new int[101];
            int count=0;
            for(int j=i;j<nums.size();j++)
            {
                if(freq[nums.get(j)]==0) count++;
                freq[nums.get(j)]++;
                ans+=count*count;
            }
        }
        return ans;
    }
}