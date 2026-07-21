class Solution {
    public static long ans;
    public static long dfs(List<List<Integer>> adj,int i,int j,int[] base)
    {
        List<Integer> li=adj.get(i);
        if(li.size() == 0) return base[i];
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(int x:li)
        {
            long val=dfs(adj,x,0,base);
            max=Math.max(max,val);
            min=Math.min(min,val);
        }
        return max + ((max-min)+base[i]);
    }
    public long finishTime(int n, int[][] edges, int[] base) {
        List<List<Integer>> adj =new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e:edges)
        {
            adj.get(e[0]).add(e[1]);
        }
        ans=0;
        return dfs(adj,0,0, base);
    }
}