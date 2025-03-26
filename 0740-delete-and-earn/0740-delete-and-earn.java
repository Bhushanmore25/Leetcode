class Solution {
    public static int helper(int num,Map<Integer,Integer> sums,Map<Integer,Integer> memo)
    {
        if(num<=0) return 0;
        if(memo.containsKey(num)) return memo.get(num);

        int skip=helper(num-1,sums,memo);
        int take=sums.getOrDefault(num,0) + (num-1>=0 ? helper(num-2,sums,memo) : 0);
        int result = Math.max(skip, take);
        memo.put(num,result);
        return result;
    }
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> sums=new HashMap<>();
        Map<Integer,Integer> memo=new HashMap<>();
        int maxi=0;
        for(int i=0;i<nums.length;i++)
        {
            sums.put(nums[i],sums.getOrDefault(nums[i],0)+nums[i]);
            maxi=Math.max(maxi,nums[i]);
        }
        return helper(maxi,sums,memo);
    }
}