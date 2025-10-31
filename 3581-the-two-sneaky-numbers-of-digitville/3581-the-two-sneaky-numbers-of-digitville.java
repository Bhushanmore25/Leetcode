class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int[] ans=new int[2];
        int j=0;
        for(int i:nums)
        {
            if(!set.contains(i)) set.add(i);
            else ans[j++]=i;
        }
        return ans;
    }
}