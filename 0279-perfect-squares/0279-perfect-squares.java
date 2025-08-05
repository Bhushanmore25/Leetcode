// class Solution {
//     public int numSquares(int n) {
//         Queue<Integer> queue = new LinkedList<>();
//         Set<Integer> visited = new HashSet<>();

//         queue.offer(n);
//         visited.add(n);
//         int level = 0;

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             level++;

//             for (int i = 0; i < size; i++) {
//                 int curr = queue.poll();

//                 for (int j = 1; j * j <= curr; j++) {
//                     int next = curr - j * j;
//                     if (next == 0) return level;
//                     if (!visited.contains(next)) {
//                         queue.offer(next);
//                         visited.add(next);
//                     }
//                 }
//             }
//         }

//         return level; 
//     }
// }
// Time complexity: O(N * sqrt(N))
// Space complexity: O(N)
	
class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }
    
    public int helper(int n, int[] memo) {
        if (n < 4)
            return n;
        
        if (memo[n] != 0)
            return memo[n];
        
        int ans = n;
        
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + helper(n - square, memo));
        }
        
        return memo[n] = ans;
    }
}