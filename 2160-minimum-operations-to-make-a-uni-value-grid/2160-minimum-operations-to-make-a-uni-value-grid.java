class Solution {
    public int minOperations(int[][] grid, int x) {
       int rows = grid.length;
        int cols = grid[0].length;
        if (rows == 1 && cols == 1) return 0;
        List<Integer> nums = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                nums.add(num);
            }
        }
        Collections.sort(nums);
        int mid = nums.get(nums.size() / 2);
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            ans += Math.abs(nums.get(i) - mid) / x;
            if (i > 0 && Math.abs(nums.get(i) - nums.get(i - 1)) % x != 0) {
                return -1;
            }
        }

        return ans;
    }
}