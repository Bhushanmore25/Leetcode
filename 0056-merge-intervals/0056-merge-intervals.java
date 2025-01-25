class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int[] i: intervals)
        {
            if(i[0]<=end)
            {
                end=Math.max(end,i[1]);
            }
            else{
                res.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        res.add(new int[]{start,end});
        int[][] ans=new int[res.size()][2];
        for(int i=0;i<res.size();i++)
        {
            int[] x=res.get(i);
            ans[i][0]=x[0];
            ans[i][1]=x[1];
        }
        return ans;
    }
}