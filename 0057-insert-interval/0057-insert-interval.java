class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0, n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        int min = newInterval[0], max = newInterval[1];
        while (i < n && intervals[i][0] <= newInterval[1]) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
            i++;
        }
        list.add(new int[]{min, max});
        while (i < n) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}