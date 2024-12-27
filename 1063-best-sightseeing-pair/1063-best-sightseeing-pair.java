class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int first=values[0];
        int maxi=0;
        int second=0;
        for(int i=1;i<n;i++)
        {
            second=values[i]-i;
            maxi=Math.max(maxi,first+second);
            first=Math.max(first,values[i]+i);
        }
        return maxi;
    }
}