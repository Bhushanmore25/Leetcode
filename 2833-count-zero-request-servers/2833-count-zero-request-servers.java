class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            temp.add(new int[] {i, queries[i]});
        }
        Collections.sort(temp, (a, b) -> a[1] - b[1]);

        int[] ans = new int[queries.length];
        Map<Integer, Integer> active = new HashMap<>();
        int l= 0;
        int r = 0; 
        for (int[] query : temp) {
            int queryId = query[0];
            int queryStart = query[1] - x;
            int queryEnd = query[1];
            while (r < logs.length && logs[r][1] <= queryEnd) {
                int server = logs[r][0];
                active.put(server, active.getOrDefault(server, 0) + 1);
                r++;
            }
            
            while (l < logs.length && logs[l][1] < queryStart) {
                int server = logs[l][0];
                active.put(server, active.get(server) - 1);
                if (active.get(server) == 0) active.remove(server);
                l++;
            }

            ans[queryId] = n - active.size();
        }
        return ans;
    }
}