class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int target = totalSum - x;
        if (target < 0) return -1; 
        if (target == 0) return nums.length; 

        int left = 0, currentSum = 0, maxLen = -1;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (left <= right && currentSum > target) {
                currentSum -= nums[left++];
            }

            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return (maxLen == -1) ? -1 : nums.length - maxLen;
    }
}
