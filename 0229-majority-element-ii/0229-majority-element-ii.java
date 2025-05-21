class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        int count=(int)Math.floor(nums.length/3);
        List<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> ele:map.entrySet())
        {
            if(ele.getValue()>count) ans.add(ele.getKey());
        }
        return ans;
    }
}