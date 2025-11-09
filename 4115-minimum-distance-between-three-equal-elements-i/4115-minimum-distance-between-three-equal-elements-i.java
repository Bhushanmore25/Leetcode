class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            List<Integer> temp = map.get(nums[i]);
            temp.add(i);

            if (temp.size() >= 3) {
                int n = temp.size();
                int k = temp.get(n - 1);   
                int ii = temp.get(n - 2);  
                int j = temp.get(n - 3);   

                int tp = Math.abs(ii - j) + Math.abs(j - k) + Math.abs(k - ii);
                ans = Math.min(ans, tp);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
