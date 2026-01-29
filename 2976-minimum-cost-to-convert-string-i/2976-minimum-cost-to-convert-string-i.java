class Solution {
    public static void floyd_Warshal(long[][] dist) {
        for (int A = 0; A < 26; A++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][A] != Integer.MAX_VALUE && dist[A][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][A] + dist[A][j]);
                    }
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long ans = 0;
        long[][] dist = new long[26][26];
        for (long i[] : dist)
            Arrays.fill(i, Integer.MAX_VALUE);
        for (int i = 0; i < 26; i++)
            dist[i][i] = 0L;
        for (int i = 0; i < original.length; i++) {
            int src = original[i] - 'a';
            int dest = changed[i] - 'a';
            dist[src][dest] = (long) Math.min(dist[src][dest], cost[i]);
        }
        floyd_Warshal(dist);
        for (int i = 0; i < source.length(); i++) {
            int src = source.charAt(i) - 'a';
            int dest = target.charAt(i) - 'a';
            if (dist[src][dest] == Integer.MAX_VALUE)
                return -1;
            ans += dist[src][dest];
        }
        return ans;
    }
}