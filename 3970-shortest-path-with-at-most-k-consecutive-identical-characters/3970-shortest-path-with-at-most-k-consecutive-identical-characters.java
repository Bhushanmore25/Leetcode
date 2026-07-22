import java.util.*;

class Solution {

    static class Node {
        int u;
        int count;
        int wt;

        Node(int u, int count, int wt) {
            this.u = u;
            this.count = count;
            this.wt = wt;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int INF = (int) 1e9;
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);

        dist[0][1] = 0;
        pq.offer(new Node(0, 1, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            int u = curr.u;
            int count = curr.count;
            int wt = curr.wt;

            if (u == n - 1) {
                return wt;
            }

            if (wt > dist[u][count]) {
                continue;
            }

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int edgeWt = edge[1];

                int nextCount = (labels.charAt(v) == labels.charAt(u)) ? count + 1 : 1;

                if (nextCount > k) {
                    continue;
                }

                int nextWt = wt + edgeWt;

                if (nextWt < dist[v][nextCount]) {
                    dist[v][nextCount] = nextWt;
                    pq.offer(new Node(v, nextCount, nextWt));
                }
            }
        }

        return -1;
    }
}