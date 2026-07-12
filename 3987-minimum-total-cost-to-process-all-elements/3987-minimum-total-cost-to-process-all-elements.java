class Solution {
    static final int MOD = 1000000007;
    static final long MOD_INV_2 = 500000004; 

    public static long findCost(long count, long req) {
        long n = req % MOD;
        long first = count % MOD;
        long last = (count + req - 1) % MOD;
        
        long sum = (n * ((first + last) % MOD)) % MOD;
        return (sum * MOD_INV_2) % MOD;
    }

    public int minimumCost(int[] nums, int k) {
        long ans = 0;
        long count = 1; 
        long avil = k;
        
        for (int i : nums) {
            if (i <= avil) {
                avil -= i;
            } else {
                long needed = i - avil;
                long req = (needed + k - 1) / k; 
                ans = (ans + findCost(count, req)) % MOD;
                count += req; 
                avil += (req * k) - i;
            }
        }
        
        return (int) ans;
    }
}