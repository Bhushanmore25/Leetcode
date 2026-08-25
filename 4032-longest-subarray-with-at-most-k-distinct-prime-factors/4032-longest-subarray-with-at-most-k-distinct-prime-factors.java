class Solution {

    private int[] getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        List<Integer> primeList = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeList.add(i);

                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        int[] primes = new int[primeList.size()];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = primeList.get(i);
        }
        return primes;
    }

    private List<Integer> fact(int n, int[] primes) {
        List<Integer> factors = new ArrayList<>();

        for (int p : primes) {
            if ((long) p * p > n)
                break;

            if (n % p == 0) {
                factors.add(p);

                while (n % p == 0) {
                    n /= p;
                }
            }
        }
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int maxi = Arrays.stream(nums).max().getAsInt();

        int[] primes = getPrimes(maxi);

        List<List<Integer>> factors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            factors.add(fact(nums[i], primes));
        }
        int[] freq = new int[maxi + 1];

        int distinct = 0;
        int left = 0;
        int res = 0;
        for (int right = 0; right < n; right++) {

            for (int p : factors.get(right)) {
                if (freq[p] == 0) {
                    distinct++;   
                }
                freq[p]++;
            }
            while (distinct > k) {
                for (int p : factors.get(left)) {
                    freq[p]--;
                    if (freq[p] == 0) {
                        distinct--;   
                    }
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}