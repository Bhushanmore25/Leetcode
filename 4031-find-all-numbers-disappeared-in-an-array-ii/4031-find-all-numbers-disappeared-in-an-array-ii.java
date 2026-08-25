class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        long next = lower;

        for (int num : nums) {

            if (num < lower || num > upper) {
                continue;
            }

            if (num > next) {
                List<Integer> range = new ArrayList<>();
                range.add((int) next);
                range.add(num - 1);
                ans.add(range);
            }

            if (num >= next) {
                next = (long) num + 1;
            }
        }

        if (next <= upper) {
            List<Integer> range = new ArrayList<>();
            range.add((int) next);
            range.add(upper);
            ans.add(range);
        }

        return ans;
    }
}