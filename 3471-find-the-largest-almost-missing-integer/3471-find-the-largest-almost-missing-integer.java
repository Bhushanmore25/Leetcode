class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        
        for(int i=0;i<=nums.length-k;i++)
        {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i; j < i + k; j++) {  
                if (!seen.contains(nums[j])) {
                    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                    seen.add(nums[j]);
                }
            }
        }
        int ans=-1;
        for(int x:map.keySet())
        {
            if(map.get(x)==1)
            {
                ans=Math.max(ans,x);
            }
        }
        return ans;
    }
}