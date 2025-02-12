class Solution {
    public static int getSum(int n)
    {
        int sum=0;
        while(n!=0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int sum=getSum(nums[i]);
            map.putIfAbsent(sum, new PriorityQueue<>(Collections.reverseOrder())); 
            map.get(sum).add(nums[i]);
        }
        int maxi=-1;
        for(int i:map.keySet())
        {
            PriorityQueue<Integer> pr=new PriorityQueue<>(Collections.reverseOrder());
            pr=map.get(i);
            if(pr.size()>=2)
            {
                int x=pr.poll();
                int y=pr.poll();
                maxi=Math.max(maxi,x+y);
            }
        }
        return maxi;
    }
}