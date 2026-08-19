import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] s) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] seat : s) {

            int row = seat[0];
            int col = seat[1];

            if (!map.containsKey(row)) {
                map.put(row, new ArrayList<>());
            }

            List<Integer> li = map.get(row);
            if (col >= 2 && col <= 5 && !li.contains(1)) {
                li.add(1);
            }
            if (col >= 4 && col <= 7 && !li.contains(2)) {
                li.add(2);
            }
            if (col >= 6 && col <= 9 && !li.contains(3)) {
                li.add(3);
            }
        }
        int total = n * 2;

        for (List<Integer> li : map.values()) {
            total -= 2;

            boolean group1Blocked = li.contains(1);
            boolean group2Blocked = li.contains(2);
            boolean group3Blocked = li.contains(3);
            if (!group1Blocked && !group3Blocked) {
                total += 2;
            }
            else if (!group1Blocked || !group2Blocked || !group3Blocked) {
                total += 1;
            }
        }

        return total;
    }
}