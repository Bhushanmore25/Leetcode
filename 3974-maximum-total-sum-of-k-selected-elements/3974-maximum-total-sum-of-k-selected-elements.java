class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        int n=nums.length;
        long total=0l;

        for(int i=n-1 ; (i>=0 && k>0) ; i--,mul--,k--)
        {
            if(mul>0)
            {
                total+=((long)nums[i]*mul);
            }
            else{
                total+=(long)nums[i];
            }
        }
        return total;
    }
}