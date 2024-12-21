class Solution {
    public static long DFS(List<List<Integer>> adj, int k,int[] values,int[] count ,int curr, int parent)
    {
        long sum=values[curr];
        for(int nbr: adj.get(curr))
        {
            if(nbr!=parent)
            {
                sum+=DFS(adj, k , values , count , nbr , curr);
            }
        }
        sum%=k;
        if(sum==0)
        {
            count[0]++;
        }
        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] li:edges)
        {
            adj.get(li[0]).add(li[1]);
            adj.get(li[1]).add(li[0]);
        }
        int[] count=new int[1];
        DFS(adj, k , values, count , 0 , -1);
        return count[0];
    }
}