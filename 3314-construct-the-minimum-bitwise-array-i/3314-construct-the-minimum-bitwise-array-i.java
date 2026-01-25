class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans=new int[nums.size()];
        for(int i=0;i<nums.size();i++)
        {
            int j=1;
            ans[i]=-1;
            for(;j<=nums.get(i);j++)
            {
                if((j|(j+1))==nums.get(i)){
                    ans[i]=j;
                    break;
                }
            }
        }
        return ans;
    }
}