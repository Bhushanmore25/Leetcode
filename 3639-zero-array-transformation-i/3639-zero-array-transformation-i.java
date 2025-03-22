class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff=new int[nums.length+1];
        for(int i=0;i<queries.length;i++)
        {
            int l=queries[i][0];
            int r=queries[i][1];
            diff[l]++;
            diff[r+1]--;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=diff[i];
            if(sum<nums[i]) return false;
        }
        return true;
    }
}