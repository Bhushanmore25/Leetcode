class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        int[] dist=new int[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            if(i!=src)
                dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<flights.length;i++)
        {
            int sc=flights[i][0];
            int dt=flights[i][1];
            int pri=flights[i][2];
            adj.get(sc).add(new int[]{dt,pri});
        }

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0,0}); // dest - cost - stops
        while(!q.isEmpty())
        {
            int[] temp=q.remove();

           if (temp[2] > k) continue;

            for (int[] nei : adj.get(temp[0])) {
                int nextNode = nei[0];
                int price = nei[1];

                if (temp[1] + price < dist[nextNode]) {
                    dist[nextNode] = temp[1] + price;
                    q.add(new int[]{nextNode, dist[nextNode], temp[2] + 1});
                }
            }
        }

        if(dist[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }
        else 
        {
            return dist[dst];
        }
    }
}