class Solution {
    public static int sumdigits(int n)
    {
        int sum=0;
        while(n!=0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = 0;

        for (int i = 1; i <= n; i++) {
            int x = sumdigits(i);
            map.put(x, map.getOrDefault(x, 0) + 1);
            maxi = Math.max(maxi, map.get(x));
        }
        int count=0;
        for(int value:map.values())
        {
            if(value==maxi) count++;
        }
        return count;
    }
}