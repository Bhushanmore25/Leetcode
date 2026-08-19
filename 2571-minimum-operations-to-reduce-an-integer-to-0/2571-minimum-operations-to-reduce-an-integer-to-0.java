import java.util.*;

class Solution {

    List<Integer> powers = new ArrayList<>();
    Map<Integer, Integer> dp = new HashMap<>();

    public int minOperations(int n) {

        // Create powers of 2 up to and above n
        int x = 1;

        while (x <= n) {
            powers.add(x);
            x *= 2;
        }

        // Add the first power greater than n
        powers.add(x);

        return solve(n);
    }

    private int solve(int n) {

        if (n == 0) {
            return 0;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        // Find the position of the first power >= n
        int idx = Collections.binarySearch(powers, n);

        if (idx < 0) {
            idx = -idx - 1;
        }

        // n itself is a power of 2
        if (idx < powers.size() && powers.get(idx) == n) {
            dp.put(n, 1);
            return 1;
        }

        int upper = powers.get(idx);
        int lower = powers.get(idx - 1);

        // Option 1: subtract lower power
        int useLower = 1 + solve(n - lower);

        // Option 2: add (upper - n), equivalently move to upper
        int useUpper = 1 + solve(upper - n);

        int ans = Math.min(useLower, useUpper);

        dp.put(n, ans);

        return ans;
    }
}