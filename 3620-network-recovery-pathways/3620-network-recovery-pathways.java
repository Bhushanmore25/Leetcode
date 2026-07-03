import java.util.*;

class Solution {

    static class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private static final long INF = (long) 1e18;

    public long dfs(int curr, List<List<Pair>> graph, boolean[] online, long limit, long[] memo) {

        if (!online[curr]) {
            return INF;
        }

        if (curr == online.length - 1) {
            return 0;
        }

        if (memo[curr] != -1) {
            return memo[curr];
        }

        long minCost = INF;

        for (Pair child : graph.get(curr)) {
            int childNode = child.node;
            int cost = child.cost;

            if (cost >= limit) {
                long temp = dfs(childNode, graph, online, limit, memo);

                if (temp != INF) {
                    minCost = Math.min(minCost, cost + temp);
                }
            }
        }

        memo[curr] = minCost;
        return minCost;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            graph.get(u).add(new Pair(v, cost));
        }

        long low = 0;
        long high = (long) 1e9;
        int ans = -1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            long[] memo = new long[n];
            Arrays.fill(memo, -1);

            long totalCost = dfs(0, graph, online, mid, memo);

            if (totalCost <= k) {
                ans = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}