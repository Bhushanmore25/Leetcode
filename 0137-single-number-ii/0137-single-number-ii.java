class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums) map.put(i,map.getOrDefault(i,0)+1);
        for(Map.Entry<Integer,Integer> ele:map.entrySet()) if(ele.getValue()==1) return ele.getKey();
        return -1;
    }
}