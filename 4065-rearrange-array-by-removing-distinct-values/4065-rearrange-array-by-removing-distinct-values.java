class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] x = new int[101];

        for (int i : nums) {
            x[i]++;
        }

        int k = 0, i = 1;

        while (k != nums.length) {
            while (x[i] == 0) {
                i=(i+1)%101;
            }

            nums[k++] = i;
            x[i]--;
            i++;
            
            if (i > 100) {
                i = 1;
            }
        }

        return nums;
    }
}