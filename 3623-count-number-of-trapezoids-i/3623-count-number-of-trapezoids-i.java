class Solution {
    static final int MOD = 1_000_000_007;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i[]:points)
        {
            map.put(i[1],map.getOrDefault(i[1],0)+1);
        }
        List<Long> li=new ArrayList<>();
        long sum=0;
        for (int cnt : map.values()) {
            if (cnt > 1) {
                long val = (long) cnt * (cnt - 1) / 2 % MOD; 
                li.add(val);
                sum = (sum + val) % MOD;
            }
        }
        int n = li.size();
        long ans = 0;

        for (long x : li) {
            sum = (sum - x + MOD) % MOD; 
            ans = (ans + x * sum) % MOD; 
        }

        return (int) ans;
    }
}  