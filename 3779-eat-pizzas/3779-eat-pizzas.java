class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n = pizzas.length, days = n / 4;
        long totalWeight = 0;
        int index = n - 1;

        for (int day = 1; day <= days; day += 2) {
            totalWeight += pizzas[index--];
        }
        index--;
        for (int day = 2; day <= days; day += 2) {
            totalWeight += pizzas[index];
            index -= 2;
        }
        return totalWeight;
    }
}