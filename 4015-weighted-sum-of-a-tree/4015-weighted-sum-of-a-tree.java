class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<parent.length;i++) adj.add(new ArrayList<>());
        for(int i=1;i<parent.length;i++) adj.get(parent[i]).add(i);
        Queue<Integer> q=new ArrayDeque<>();
        q.add(0);
        q.add(-1);
        int h=0;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            if(curr==-1) {
                h++;
                if (!q.isEmpty()) {
                    q.add(-1);
                }
                continue;
            }
            for(int i:adj.get(curr)) q.add(i);
        }
        int d=1;
        q.clear();
        q.add(0);
        q.add(-1);
        long ans=0l;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            if(curr==-1) {
                d++;
                if (!q.isEmpty()) {
                    q.add(-1);
                }
                continue;
            }
            ans+=(long)nums[curr] * (long)(h-d+1);
            for(int i:adj.get(curr)) {
                q.add(i);
            }
        }
        return ans;
    }
}