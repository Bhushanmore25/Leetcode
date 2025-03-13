class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        if(!transform(nums,queries,queries.length)) return -1;

        int left=0,right=queries.length;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(transform(nums,queries,mid))
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
    public static boolean transform(int[] nums,int[][] queries,int k)
    {
        int[] diff=new int[nums.length+1];
        for(int i=0;i<k;i++)
        {
            int l=queries[i][0],r=queries[i][1],val=queries[i][2];
            diff[l]+=val;
            diff[r+1]-=val;
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