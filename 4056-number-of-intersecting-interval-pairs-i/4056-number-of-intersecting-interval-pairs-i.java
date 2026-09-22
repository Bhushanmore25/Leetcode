class Solution {
    public int countIntersectingIntervals(int[][] in) {
        int count=0;
        for(int i=0;i<in.length-1;i++)
        {
            int x1=in[i][0];
            int y1=in[i][1];
            for(int j=i+1;j<in.length;j++){
                int x2=in[j][0];
                int y2=in[j][1];
                if(Math.max(x1,x2) <= Math.min(y1,y2)) count++;
            }
        }
        return count;
    }
}