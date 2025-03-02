class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            if(!map.containsKey(nums1[i][0])) pq.add(nums1[i][0]);
            map.put(nums1[i][0],map.getOrDefault(nums1[i][0],0)+nums1[i][1]);
        }

        for(int i=0;i<nums2.length;i++)
        {
            if(!map.containsKey(nums2[i][0])) pq.add(nums2[i][0]);
            map.put(nums2[i][0],map.getOrDefault(nums2[i][0],0)+nums2[i][1]);
        }
        int n=pq.size();
        int[][] ans=new int[n][2];
        for(int i=0;i<n;i++)
        {
            int x=pq.poll();
            int y=map.get(x);
            ans[i][0]=x;
            ans[i][1]=y;
        }
        return ans;
    }
}