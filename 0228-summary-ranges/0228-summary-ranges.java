class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        if(nums.length==0) return ans;
        if(nums.length==1)
        {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }

        int start=nums[0],end=-1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==(nums[i-1]+1) || nums[i]==nums[i-1]) continue;
            else{
                end=nums[i-1];
                if(start==end) ans.add(String.valueOf(start));
                else ans.add(start + "->" + end);
                start=nums[i];
            }
        }
        end=nums[nums.length-1];
        if(start==end) ans.add(String.valueOf(start));
        else ans.add(start + "->" + end);
        return ans;
    }
}