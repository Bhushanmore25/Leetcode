class Solution {

    public int minOperations(String s) {

        int cost = increment(s);

        for (int i = 1; i < s.length(); i++) {

            String x = s.substring(i) + s.substring(0, i);

            cost = Math.min(cost,i+ increment(x));
        }

        return cost;
    }

    public static int increment(String s) {

        int count = 0;
        int l = 0, r = s.length() - 1;

        while (l < r) {

            int diff = Math.abs(s.charAt(l) - s.charAt(r));

            count += Math.min(diff, 26 - diff);

            l++;
            r--;
        }

        return count;
    }
}