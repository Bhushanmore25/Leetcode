class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumDecoded(long[] nums) {
        long ans = 0;

        for (long num : nums) {
            int width = (int) (num % 10);
            long d = num / 10;

            String dStr = String.valueOf(d);
            long x = Long.parseLong(dStr.substring(0, width));
            long y = Long.parseLong(dStr.substring(width));
            ans = (ans + power(x, y)) % MOD;
        }

        return (int) ans;
    }
    
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}