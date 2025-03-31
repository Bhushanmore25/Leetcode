class Solution {
    public int integerReplacement(int n) {
        if (Integer.MAX_VALUE == n) n--;
        int count = 0;

        while (n != 1) {
            if (n % 2 == 0)
                n /= 2;
            else if (n == 3 || (n - 1) % 4 == 0)
                n--;
            else
                n++;

            count++;
        }
        
        return count;
    }
}
// class Solution {
//   Map<Integer, Integer> results = new HashMap<>();

//   public int integerReplacement(int n) {
//     if (n == 1) {
//       return 0;
//     }
//     if (n == Integer.MAX_VALUE) {
//       return 32;
//     }
//     if (!results.containsKey(n)) {
//       if (n % 2 == 0) {
//         results.put(n, integerReplacement(n / 2));
//       } else {
//         // n is odd
//         results.put(n, Math.min(
//             integerReplacement(n - 1),
//             integerReplacement(n + 1)));
//       }
//     }
//     return 1 + results.get(n);
//   }
// }