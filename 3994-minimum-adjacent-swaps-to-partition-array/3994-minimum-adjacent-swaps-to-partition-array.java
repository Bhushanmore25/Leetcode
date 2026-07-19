class Solution {
    static long MOD=1_000_000_007;
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long ans=0,mid=0,last=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<a){ 
                ans= (ans+mid+last)%MOD;
            }
            else if(nums[i]>=a && nums[i]<=b){ 
                ans=(ans+last)%MOD;
                mid++;    
            }
            else last++;
        }
        return (int)(ans%MOD);
    }
}