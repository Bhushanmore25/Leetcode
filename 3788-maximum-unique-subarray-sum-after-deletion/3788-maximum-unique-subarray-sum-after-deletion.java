class Solution {
    public int maxSum(int[] nums) {
        int left = 0, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        if(nums.length==1) return nums[0];
        int mini=Integer.MIN_VALUE;
        for (int i= 0; i < nums.length; i++) {
            if(!set.contains(nums[i]) && nums[i]>0) {
                sum+=nums[i];
                set.add(nums[i]);
            }
            mini=Math.max(mini,nums[i]);
        }

        return sum == 0 ? mini : sum;
    }
}