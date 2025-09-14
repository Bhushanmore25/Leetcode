class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums);
        int sum=Integer.MIN_VALUE;
        ArrayList<Integer> ans=new ArrayList<>();
        for (int i = nums.length - 1; i >= 0 && ans.size() < k; i--) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                sum += nums[i];
                ans.add(nums[i]);
            }
        }
         return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}