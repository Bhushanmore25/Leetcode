class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;  
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                long c = 0;
                while (i < nums.length && nums[i] == 0) { 
                    c++;
                    i++;
                }
                count += (c * (c + 1)) / 2; 
            } 
        }
        return count;
    }
}