class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(n);
        visited.add(n);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int j = 1; j * j <= curr; j++) {
                    int next = curr - j * j;
                    if (next == 0) return level;
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }

        return level; 
    }
}