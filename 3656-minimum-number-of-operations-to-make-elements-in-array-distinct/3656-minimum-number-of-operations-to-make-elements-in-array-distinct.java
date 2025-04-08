class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[101];
        for(int i = n - 1 ; i >= 0 ; i--){
            if(seen[nums[i]])
                return i / 3 + 1;
            else seen[nums[i]] = true;
        }
        return 0;
    }
    // public int minimumOperations(int[] nums) {
    //     int start = 0;
    //     int operations = 0;
        
    //     while (start < nums.length) {
    //         if (isDistinct(nums, start)) {
    //             return operations;
    //         }
    //         operations++;
    //         start += 3; 
    //     }
    //     return operations;
    // }

    // private boolean isDistinct(int[] nums, int start) {
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int i = start; i < nums.length; i++) {
    //         if (!set.add(nums[i])) { 
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}