class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        long pairs = 0;
        int l = 0, r = -1;

        while (l < n || r + 1 < n) {
            while (r + 1 < n && pairs < k) {
                r++;
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
                int count = map.get(nums[r]);
                if (count > 1) {
                    pairs += count - 1;
                }
            }

            if (pairs >= k) {
                ans += (n - r);
            }

            map.put(nums[l], map.get(nums[l]) - 1);
            pairs -= map.get(nums[l]);
            l++;
        }

        return ans;
    }
}
