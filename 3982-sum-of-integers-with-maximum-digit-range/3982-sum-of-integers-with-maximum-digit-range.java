class Solution {
    public static int minmax(int n)
    {
        int min=11,max=-1;
        while(n!=0)
        {
            int t=n%10;
            min=Math.min(min,t);
            max=Math.max(max,t);
            n/=10;
        }
        return (max-min);
    }
    public int maxDigitRange(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=-1;
        for(int i:nums){
            int val=minmax(i);
            max=Math.max(max,val);
            map.put(val,map.getOrDefault(val,0)+i);
        }
        return map.get(max);
    }
}