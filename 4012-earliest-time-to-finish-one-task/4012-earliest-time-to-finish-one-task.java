class Solution {
    public int earliestTime(int[][] tasks) {
        int total=Integer.MAX_VALUE;
        for(int[] i:tasks)
        {
            total=Math.min(total,i[0]+i[1]);
        }
        return total;
    }
}