import java.util.*;

class Solution {
    private boolean dfsCheck(int node, List<List<Integer>> adj, int vis[], int pathVis[], int check[]) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis, check)) {
                    return true;
                }
            }
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            for (int j : graph[i]) {
                adj.get(i).add(j);
            }
        }

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}
