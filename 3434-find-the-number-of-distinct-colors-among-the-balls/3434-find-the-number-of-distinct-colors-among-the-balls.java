class Solution {
    public int[] queryResults(int limit, int[][] queries) {
         HashMap<Integer, Integer> query = new HashMap<>();
        HashMap<Integer, Integer> colors = new HashMap<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (query.containsKey(x)) {
                int oldColor = query.get(x);
                colors.put(oldColor, colors.get(oldColor) - 1);
                if (colors.get(oldColor) == 0) {
                    colors.remove(oldColor);
                }
            }
            query.put(x, y);
            colors.put(y, colors.getOrDefault(y, 0) + 1);
            ans[i] = colors.size();
        }

        return ans;
    }
}