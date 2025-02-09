class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        long totalpairs=(long)n*(n-1)/2;
        HashMap<Integer,Long> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i]-i;
            totalpairs-=map.getOrDefault(x,0L);
            map.put(x,map.getOrDefault(x,0L)+1);
        }
        return totalpairs;
    }
}
