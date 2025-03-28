class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows=grid.length,cols=grid[0].length;
        int[] result=new int[queries.length];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        List<int[]> sortedQueries=new ArrayList<>();
        int[][] visited=new int[rows][cols];
        for(int i=0;i<queries.length;i++)
        {
            sortedQueries.add(new int[]{queries[i],i});
        }
        sortedQueries.sort(Comparator.comparingInt(a->a[0]));
        pq.add(new int[]{grid[0][0],0,0});
        visited[0][0]=1;
        int point=0;
        for(int[] qu:sortedQueries)
        {
            int queryVal=qu[0],queryIdx=qu[1];
            while(!pq.isEmpty() && pq.peek()[0] < queryVal)
            {
                int[] top=pq.poll();
                int row=top[1],col=top[2];
                point++;
                for(int dir[]:directions)
                {
                    int nr=row+dir[0],nc=col+dir[1];
                    if(nr>=0 && nr < rows && nc>=0 && nc<cols && visited[nr][nc]==0)
                    {
                        pq.offer(new int[]{grid[nr][nc],nr,nc});
                        visited[nr][nc]=1;
                    }
                }
            }
            result[queryIdx]=point;
        }
        return result;

    }
}