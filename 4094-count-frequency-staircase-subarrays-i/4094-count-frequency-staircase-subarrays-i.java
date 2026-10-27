class Solution {
    public boolean check(Map<Integer,Integer> map)
    {
        int x=1;
        for(int i:map.keySet())
        {
            if(map.get(i)!=x) return false;
            x++;
        }
        return true;
    }
    public int countStaircase(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            Map<Integer,Integer> map=new LinkedHashMap<>();
            for(int j=i;j<nums.length;j++)
            {
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                ans += check(map) ? 1 : 0; 
            }
        }
        return ans;
    }
}