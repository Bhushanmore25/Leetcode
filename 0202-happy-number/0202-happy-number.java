class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seenElements = new HashSet<>();
        while(n != 1 && !seenElements.contains(n)){
            seenElements.add(n);
            n = getSumOfSquaresOfDigits(n);
        }
        while (n != 1 && n != 4) {
            n = getSumOfSquaresOfDigits(n);
        }
        return n == 1;

    }

    public int getSumOfSquaresOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += ((n % 10) * (n % 10));
            n /= 10;
        }
        return sum;
    }
}