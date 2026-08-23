class Solution {

    public static int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int nearestDrone(int[][] drones, int[] target) {

        int min = drones.length;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < drones.length; i++) {

            int val = manhattanDistance(
                drones[i][0],
                drones[i][1],
                target[0],
                target[1]
            );

            if (val <= drones[i][2] && val < minVal) {
                minVal = val;  
                min = i;
            }
        }

        return min==drones.length? -1: min;
    }
}