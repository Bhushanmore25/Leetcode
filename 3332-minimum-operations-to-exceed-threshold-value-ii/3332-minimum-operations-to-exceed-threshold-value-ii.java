class Solution {
     public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=k)
                pq.add(nums[i]);
        }
        int times=0;
        while(!pq.isEmpty()&&pq.peek()<k){

           int first =  pq.poll();
           if(pq.isEmpty()){
            times++;
            break;
           }
           int sec = pq.poll();
           long num = (long)(first*2) +sec;
            if(num < k)
            pq.add((int)num);
            
           times++;
        }

        return times;
    }
}