class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> h=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int n: stones)
        {
            h.add(n);
        }
        while(h.size()>1)
        {
            int x=h.poll();
            int y=h.poll();
            if(x!=y)
            {
                h.add(x-y);
            }
        }
        return h.size()>0?h.poll():0;
    }
}