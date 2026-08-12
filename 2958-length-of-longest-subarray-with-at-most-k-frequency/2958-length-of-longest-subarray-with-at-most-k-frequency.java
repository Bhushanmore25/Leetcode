class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int len=0,last=0;
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            int freq=map.get(nums[i]);
            if(freq<=k)
            {
                len=Math.max(len,i-last+1);
            }
            else{
                len=Math.max(len,i-last);
                while(map.get(nums[i])>k)
                {
                    map.put(nums[last],map.get(nums[last])-1);
                    last++;
                }

            }
        }
        return len;
    }
}