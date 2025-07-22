class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, len = Integer.MAX_VALUE, n = nums.length;

        for (int r = 0; r < n; r++) {
            sum += nums[r];

            while (sum >= target) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
