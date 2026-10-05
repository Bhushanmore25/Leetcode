class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n=nums.length;
        int basePairs=0;
        Map<String,Integer> map=new HashMap<>();
        int maxPairs=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1]) basePairs++;
            else{
                int x=Math.min(nums[i],nums[i+1]);
                int y=Math.max(nums[i],nums[i+1]);
                String key = x + "_" + y;
                map.put(key,map.getOrDefault(key,0)+1);
                if(map.get(key)>maxPairs) maxPairs=map.get(key);
            }
        }
        return basePairs + maxPairs;
    }
}