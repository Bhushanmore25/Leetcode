class Solution {
    public int dfs(int node, List<List<int[]>> graph, boolean[] visited, int minScore) {
        visited[node] = true;
        for (int[] edge : graph.get(node)) {
            int neighbor = edge[0];
            int weight = edge[1];
            minScore = Math.min(minScore, weight);
            if (!visited[neighbor]) {
                minScore = Math.min(minScore, dfs(neighbor, graph, visited, minScore));
            }
        }
        return minScore;
    }

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        boolean[] visited = new boolean[n + 1];
        return dfs(1, graph, visited, Integer.MAX_VALUE);
    }
}
