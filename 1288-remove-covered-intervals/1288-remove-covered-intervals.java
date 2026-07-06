class Solution {
    public int removeCoveredIntervals(int[][] intv) {
        List<int[]> a=new ArrayList<>();
        Arrays.sort(intv,(x,y)->{
            if(x[0]==y[0]) return y[1]-x[1];
            return x[0]-y[0];
        });
        int st=intv[0][0],end=intv[0][1];
        for(int i[]:intv)
        {
            if(i[0]>=st && i[1] <=end){
                continue;
            }
            else{
                a.add(new int[]{st,end});
                st=i[0];
                end=i[1];
            }
        }
        a.add(new int[]{st,end});
        return a.size();
    }
}