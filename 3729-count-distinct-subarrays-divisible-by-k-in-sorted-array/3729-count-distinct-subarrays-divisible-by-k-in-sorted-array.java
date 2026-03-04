class Solution {
    public long numGoodSubarrays(int[] nums, int k) {
    long ans = 0;
    long[] ps = new long[nums.length+1];
    for(int i = 0; i < nums.length; ++i){  
        ps[i+1] = nums[i] + ps[i];
    }

    Map<Long, Long> map = new HashMap<>();
    map.put(0L, 1L);
    for(int i = 0; i < nums.length; ++i){
        Long key = (long)(ps[i+1])%k;
        ans += map.getOrDefault(key, 0L);
        map.put(key, map.getOrDefault(key, 0L) + 1L);
    }

    Map<String, Long> map2 = new HashMap<>();
    for(int i = 0; i < nums.length; ++i){
        String key = Long.toString((long)(ps[i+1])%k) + "#" + Integer.toString(nums[i]);
        ans -= map2.getOrDefault(key, 0L);
        map2.put(key, map2.getOrDefault(key, 0L) + 1L);
    }
    return ans;
}
}