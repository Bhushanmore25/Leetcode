import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> li = map.get(nums[i]);
                for (int index : li) {
                    if (Math.abs(i - index) <= k) return true;
                }
                li.add(i); 
            }
        }
        return false;
    }
}
