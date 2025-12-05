class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            prefixSum += nums[i];
            int leftSum = prefixSum;
            int rightSum = totalSum - prefixSum;
            if ((leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}