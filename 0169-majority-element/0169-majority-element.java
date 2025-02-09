class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int n=nums.length/2;
        int ans=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet())
        {
            if(e.getValue()>n)
            {
                ans=e.getKey();
            }
        }
        return ans;
    }
}