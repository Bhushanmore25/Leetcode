import java.util.*;

class Solution {
    public long countStableSubarrays(int[] nums) {

        int n = nums.length;
        long[] prefix = new long[n];

        prefix[0] = nums[0];
        for(int i=1;i<n;i++)
            prefix[i] = prefix[i-1] + nums[i];

        Map<Integer, HashMap<Long,Integer>> map = new HashMap<>();

        long count = 0;

        for(int j=0;j<n;j++)
        {
            int val = nums[j];

            if(j>=2)
            {
                map.putIfAbsent(nums[j-2], new HashMap<>());
                long key = prefix[j-2] + nums[j-2];
                HashMap<Long,Integer> inner = map.get(nums[j-2]);

                inner.put(key, inner.getOrDefault(key,0)+1);
            }

            if(map.containsKey(val))
            {
                long needed = prefix[j-1];
                HashMap<Long,Integer> inner = map.get(val);

                count += inner.getOrDefault(needed,0);
            }
        }

        return count;
    }
}