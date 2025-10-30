class Solution {
    public int totalMoney(int n) {
        int[] nums = new int[n + 1]; 
        int total = 0;
        nums[1] = 1; 

        for (int i = 2; i <= n; i++) {
            if ((i - 1) % 7 == 0) 
                nums[i] = nums[i - 7] + 1;
            else
                nums[i] = nums[i - 1] + 1;
        }

        for (int i : nums) {
            total += i;
            System.out.println(i);
        }

        return total;
    }
}