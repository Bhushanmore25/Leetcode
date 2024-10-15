class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b)->b-a);
        for (int i:nums)
        {
            p.offer(i);
        }
        long score=0;
        while(!p.isEmpty() && k>0)
        {
            score+=p.peek();
            int x=(int)Math.ceil(p.poll()/3.0);
            p.add(x);
            k--;
        }
        return score;
    }
}