class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count=0;
        if(points.length==1) return count;
        for(int i=1;i<points.length;i++)
        {
            int distance1=Math.abs(points[i][0]-points[i-1][0]);
            int distance2=Math.abs(points[i][1]-points[i-1][1]);
            int minDistance=Math.min(distance1,distance2);
            int maxDistance=Math.max(distance1,distance2);
            count+=minDistance;
            count+=(maxDistance-minDistance);
        }
        return count;
    }
}