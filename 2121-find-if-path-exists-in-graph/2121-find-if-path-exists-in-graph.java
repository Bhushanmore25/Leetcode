class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i[]:edges)
        {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        boolean vis[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        vis[source]=true;
        while(!q.isEmpty())
        {
            int a=q.poll();
            if(a==destination) return true;
            for(int li:adj.get(a))
            {
                if(!vis[li])
                {
                    vis[li]=true;
                    q.add(li);

                }    
            }
        }
        return false;
    }
}