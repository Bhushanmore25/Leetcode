class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (n > 0) {
            maxHeap.offer(n % 10);
            n /= 10;
        }

        int first = maxHeap.poll();   
        int second = maxHeap.poll();  

        return first * second;
    }
}