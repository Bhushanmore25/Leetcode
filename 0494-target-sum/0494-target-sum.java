class Solution {
    public static int helperfunc(int[] nums, int target, int i, int sum, Map<String, Integer> map) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        String key = i + "_" + sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        int plus = helperfunc(nums, target, i + 1, sum + nums[i], map);
        int minus = helperfunc(nums, target, i + 1, sum - nums[i], map);
        
        int result = plus + minus;
        map.put(key, result);
        return result;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return helperfunc(nums, target, 0, 0, map);
    }
}
