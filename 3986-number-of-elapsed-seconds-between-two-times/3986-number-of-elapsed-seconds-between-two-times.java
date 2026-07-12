class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] st = startTime.split(":");
        String[] end = endTime.split(":");

        int count = 0;

        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(st[i]);
            int y = Integer.parseInt(end[i]);

            if (i == 0) count += (y - x) * 60 * 60;
            if (i == 1) count += (y - x) * 60;
            if (i == 2) count += (y - x);
        }

        return count;
    }
}