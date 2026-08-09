class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int n = prices.length;
        int m = discounts.length;

        double ans = 0;
        for (int price : prices) {
            ans += price;
        }

        int k = Math.min(n, m);

        for (int i = 0; i < k; i++) {
            int price = prices[n - 1 - i];
            int discount = discounts[m - 1 - i];

            ans -= (double) price * discount / 100.0;
        }

        return ans;
    }
}