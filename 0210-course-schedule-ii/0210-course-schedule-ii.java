class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // if(prerequisites.length==0) return new int[]{0};
        List<List<Integer>> adj=new ArrayList<>();
        int[] inDegree=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        int[] ans=new int[numCourses];
        int k=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            count++;
            ans[k++]=curr;
            for(int i:adj.get(curr))
            {
                inDegree[i]--;
                if(inDegree[i]==0)
                {
                    q.add(i);
                }
            }
        }
        if(count!=numCourses) return new int[0];
        return ans;
    }
}