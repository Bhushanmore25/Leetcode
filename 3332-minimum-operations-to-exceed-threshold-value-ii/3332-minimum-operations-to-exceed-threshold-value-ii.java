class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i:nums)
        {
            pq.offer((long)i);
        }
        int count=0;
        while(pq.peek()<k && pq.size()>=2)
        {
            long x=pq.poll();
            long y=pq.poll();
            pq.offer(x*2 + y);
            count++;
        }
        return count;
    }
}