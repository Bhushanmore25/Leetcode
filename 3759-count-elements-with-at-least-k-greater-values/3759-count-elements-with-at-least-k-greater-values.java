class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int idx = upperBound(nums, nums[i]);
            int greater = n - idx;

            if (greater >= k) count++;
        }
        return count;
    }
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}