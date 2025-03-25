class Solution {
    public static int mergeintervals(List<int[]> nums)
    {
        List<int[]> res=new ArrayList<>();
        nums.sort(Comparator.comparingInt(a -> a[0]));
        int start = nums.get(0)[0];
        int end = nums.get(0)[1];
        for(int[] i:nums)
        {
            if(i[0] < end && i[0] != end)
            {
                end=Math.max(end,i[1]);
            }
            else{
                res.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        res.add(new int[]{start, end});
        return res.size();
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> x=new ArrayList<>();
        List<int[]> y=new ArrayList<>();
        for(int[] i:rectangles)
        {
            x.add( new int[] { i[0] , i[2] } );
            y.add( new int[] { i[1] , i[3] } );
        }
        return mergeintervals(x)>=3 || mergeintervals(y)>=3;
    }
}