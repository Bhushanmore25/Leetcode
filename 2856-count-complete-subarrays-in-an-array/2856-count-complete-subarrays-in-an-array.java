class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int l=0,r=0,count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums) map.put(i,1);
        Map<Integer,Integer> temp=new HashMap<>();
        int n=nums.length;
        while (l < n) {
            while (r < n && !temp.keySet().containsAll(map.keySet())) {
                temp.put(nums[r], temp.getOrDefault(nums[r], 0) + 1);
                r++;
            }

            if (temp.keySet().containsAll(map.keySet())) {
                count += (n - r + 1);
            }
            temp.put(nums[l],temp.get(nums[l])-1);
            if (temp.get(nums[l]) == 0) {
                temp.remove(nums[l]);
            }
            l++;
        }
        return count;
    }
}