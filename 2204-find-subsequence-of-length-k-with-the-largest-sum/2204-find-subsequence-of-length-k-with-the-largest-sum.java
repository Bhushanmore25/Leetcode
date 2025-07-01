class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{nums[i], i});
        }
        list.sort((a, b) -> Integer.compare(b[0], a[0]));
        List<int[]> topK = list.subList(0, k);
        topK.sort(Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}