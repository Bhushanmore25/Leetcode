import java.util.Arrays;

class Solution {
    private int[] parent;
    
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j, int maxDiff, int[] nums) {
        if (Math.abs(nums[i] - nums[j]) <= maxDiff) {
            int irep = find(i);
            int jrep = find(j);
            if (irep != jrep) {
                parent[irep] = jrep;
            }
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] q) {
        parent = new int[n];
        boolean[] ans = new boolean[q.length];
        if (n == 1) {
            Arrays.fill(ans, true);
            return ans;
        }
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            union(i, i + 1, maxDiff, nums);
        }
        for (int k = 0; k < q.length; k++) {
            int u = q[k][0];
            int v = q[k][1];
            
            ans[k] = (find(u) == find(v));
        }
        
        return ans;
    }
}