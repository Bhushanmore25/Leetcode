import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = points.length;
        int[] prev = points[0];
        
        for (int i = 1; i < points.length; i++) {
            int[] cur = points[i];
            if (cur[0] <= prev[1]) {
                count--;
                prev = new int[]{cur[0], Math.min(cur[1], prev[1])};
            } else {
                prev = cur;
            }
        }
        return count;
    }
}
