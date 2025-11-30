class Solution {
    public static int reverse(int x)
    {
        int num=0;
        while(x!=0)
        {
            num=num*10+x%10;
            x/=10;
        }
        return num;
    }
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int idx=map.get(nums[i]);
                mini=Math.min(mini,Math.abs(idx-i));
            }
            map.put(reverse(nums[i]),i);
        }
        return mini==Integer.MAX_VALUE?-1:mini;
    }
}