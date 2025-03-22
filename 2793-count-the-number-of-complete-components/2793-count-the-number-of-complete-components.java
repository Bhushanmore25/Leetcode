import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());  
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] values = dfs(i, adj, visited, new int[]{0, 0}); 
                int nodes = values[0];
                int edgeCount = values[1] / 2; // edges are counted twice bidirectional
                
                if (nodes * (nodes - 1) / 2 == edgeCount) count++;
            }
        }

        return count;
    }

    private int[] dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited, int[] values) {
        visited[node] = true;
        values[0]++; 
        for (int neighbor : adj.get(node)) {
            values[1]++; 
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, values);
            }
        }
        return values;
    }
}
