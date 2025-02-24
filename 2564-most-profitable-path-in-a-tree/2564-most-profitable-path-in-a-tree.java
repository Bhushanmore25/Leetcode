class Solution {
    public static boolean findPath(int bob,int parent,List<Integer> curPath,List<Integer> bobPath,List<List<Integer>> adj)
    {
        if(bob==0)
        {
            bobPath.addAll(curPath);
            return true;
        }
        curPath.add(bob);
        for(int i:adj.get(bob))
        {
            if(i!=parent && findPath(i,bob,curPath,bobPath,adj))
            {
                return true;
            }
        }
        curPath.remove(curPath.size()-1);
        return false;
    }

    public static int findMaxIncome(List<List<Integer>> adj,int alice,int parent,int[] amount)
    {
        int maxIncome=Integer.MIN_VALUE;
        for (int nbr : adj.get(alice)) {
            if (nbr != parent) {
                int income = findMaxIncome(adj, nbr, alice, amount);
                if (income + amount[alice] > maxIncome) {
                    maxIncome = income + amount[alice];
                }
            }
        }
        return maxIncome == Integer.MIN_VALUE ? amount[alice] : maxIncome;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> bobPath=new ArrayList<>();
        List<Integer> curPath=new ArrayList<>();
        findPath(bob,-1,curPath,bobPath,adj);
        int size=bobPath.size();
        int i;
        for (i = 0; i < size / 2; ++i) {
            amount[bobPath.get(i)] = 0;
        }
        if (size % 2 == 1) {
            amount[bobPath.get(i)] = 0;
        } else {
            amount[bobPath.get(i)] /= 2;
        }

        return findMaxIncome(adj,0,-1,amount);

    }
}