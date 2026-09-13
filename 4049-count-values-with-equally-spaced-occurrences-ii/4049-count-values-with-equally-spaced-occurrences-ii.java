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
            if(li.size()<3) continue;
            int dist=li.get(1)-li.get(0);
            boolean flag=true;
            for(int i=1;i<li.size();i++)
            {
                if((li.get(i)-li.get(i-1)) != dist) {
                    flag=false;
                    break;
                }
            }
            if(flag)
                count += 1;
        }
        return count;
    }
}