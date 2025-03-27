class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxnum=0;
        int maxoccur=0;
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i)>maxoccur)
            {
                maxnum=i;
                maxoccur=map.get(i);
            }
        }
        if (maxoccur * 2 <= n) return -1;

        int count=0;
        for(int i=0;i<n;i++)
        {
            if(nums.get(i)==maxnum) count++;
            if (count * 2 > (i + 1) && (maxoccur - count) * 2 > (n - (i + 1))) {
                return i;
            }
        }
        return -1;
        
    }
}