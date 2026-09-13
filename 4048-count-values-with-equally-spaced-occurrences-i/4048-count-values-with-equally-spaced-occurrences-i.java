class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n=nums.length;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],new ArrayList<>());
            List<Integer> li=map.get(nums[i]);
            li.add(i);
        }
        int count=0;
        for(List<Integer> li:map.values())
        {
            if(li.size()!=3) continue;
            count += (li.get(1)-li.get(0)) == (li.get(2)-li.get(1))? 1:0;
        }
        return count;
    }
}