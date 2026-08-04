class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int l=nums[0],r=nums[nums.length-1];
        Set<Integer> set=new HashSet<>();
        for(int i:nums)
        {
            set.add(i);
        }
        int k=0;
        while(l<=r)
        {
            if(!set.contains(l)) ans.add(l);
            l++;
        }
        return ans;
    }
}