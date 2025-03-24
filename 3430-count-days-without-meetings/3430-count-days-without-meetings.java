class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int end=-1;
        int count=0;
        for(int[] meet:meetings)
        {
            if(meet[0] > end)
            {
                count+=(meet[1]-meet[0]+1);
                end=meet[1];
            }
            else if(meet[1] > end)
            {
                count+=(meet[1]-end);
                end=meet[1];
            }
        }
        return days-count;
    }
}