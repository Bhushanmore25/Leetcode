class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] fre = new int[101];

        for (int i = 0; i < nums.length; i++)
            fre[nums[i]]++;

        int[] prefix = new int[101];
        prefix[0] = fre[0];

        for (int i = 1; i <= 100; i++)
            prefix[i] = prefix[i - 1] + fre[i];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = 0;
            else
                nums[i] = prefix[nums[i] - 1];
        }

        return nums;
    }
}