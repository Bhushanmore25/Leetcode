class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int count=prices[0]+prices[1];
        return count-money <=0 ? Math.abs(count-money) : money;
    }
}