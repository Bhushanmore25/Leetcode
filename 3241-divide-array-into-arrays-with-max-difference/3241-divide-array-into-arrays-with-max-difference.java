class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        
        if (n % 3 != 0) return new int[0][0];
        
        int[][] ans = new int[n / 3][3];
        int j = 0;
        
        for (int i = 0; i < n / 3; i++) {
            int a = nums[j++];
            int b = nums[j++];
            int c = nums[j++];
            
            if (c - a > k) return new int[0][0];  
            
            ans[i][0] = a;
            ans[i][1] = b;
            ans[i][2] = c;
        }
        
        return ans;
    }
}