class Solution {

    static final int MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> horizontalLevels = new HashMap<>();

        for (int[] p : points) {
            int y = p[1];
            horizontalLevels.put(y, horizontalLevels.getOrDefault(y, 0) + 1);
        }

        List<Long> combinations = new ArrayList<>();
        for (int count : horizontalLevels.values()) {
            if (count >= 2) {
                long pairs = ((long) count * (count - 1) / 2) % MOD;
                combinations.add(pairs);
            }
        }

        long cumulative = 0;
        for (long val : combinations) {
            cumulative = (cumulative + val) % MOD;
        }

        long trapezoidCount = 0;
        for (long val : combinations) {
            cumulative = (cumulative - val + MOD) % MOD;
            trapezoidCount = (trapezoidCount + (val * cumulative) % MOD) % MOD;
        }

        return (int) trapezoidCount;
    }
}