class Solution {
    public static int find(int v,int[] uni)
    {
        if(uni[v]==-1)
        {
            return v;
        }
        return find(uni[v],uni);
    }
    public static void union(int[] uni,int a,int b)
    {
        a=find(a,uni);
        b=find(b,uni);
        uni[a]=b;
    }
    public static int[] isCyclic(List<int[]> adj,int[] uni)
    {
        for(int[] i:adj)
        {
            int a=find(i[0],uni);
            int b=find(i[1],uni);

            if(a == b)
            {
                return new int[]{i[0],i[1]};
            }
            union(uni,a,b);
        }
        return new int[]{-1,-1};
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<int[]> adj=new ArrayList<>();
        int[] uni=new int[edges.length+1];
        Arrays.fill(uni,-1);
        for(int[] i: edges)
        {
            adj.add(new int[]{i[0],i[1]});
        }

        return isCyclic(adj,uni);
    }
}